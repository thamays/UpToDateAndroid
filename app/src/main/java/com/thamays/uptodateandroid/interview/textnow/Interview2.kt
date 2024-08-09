package com.thamays.uptodateandroid.interview.textnow

import android.util.Patterns
import androidx.annotation.StringRes
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.thamays.uptodateandroid.R
import io.reactivex.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

// show loading while checking email
// show error message correctly
// only enable button valid email

class SignUpToNewsletterViewModel(
    private val submitEmailUseCase: SubmitEmailUseCase,
    private val router: SubmitEmailRouter,
    private val schedulerFacade: SchedulerFacade
) : ViewModel() {

    private val disposables = CompositeDisposable()

    var buttonEnabled = ObservableField<Boolean>()
    var input = ObservableField<String>("")
    var loading = ObservableField<Boolean>(false)
    var errorMessage = ObservableField<@receiver:StringRes Int>()

    init {
//        write your code here
        buttonEnabled.set(false)
        input.addOnPropertyChangedCallback(
            object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    buttonEnabled.set(shouldEnableButton())
                }
            }
        )
    }

    private fun shouldEnableButton(): Boolean {
        val email = input.get()
        return !email.isNullOrBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun onSubmitClick() {
        val email = input.get()
        loading.set(true)

        val disposable = submitEmailUseCase.execute(email!!)
            .subscribeOn(schedulerFacade.background)
            .observeOn(schedulerFacade.main)
            .subscribe(
                {
                    loading.set(false)
                    router.showSuccess()
                }, { error ->
                    loading.set(false)
                    errorMessage.set(
                        when (error) {
                            is SubmitEmailError.EmailAlreadyInUse -> R.string.email_already_in_use
                            is SubmitEmailError.NetworkError -> R.string.network_error
                            else -> R.string.network_error
                        }
                    )
                }
            )

        disposables.addAll(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}

interface SubmitEmailRouter {
    fun showSuccess()
}

interface SubmitEmailUseCase {
    fun execute(email: String): Completable
}

sealed class SubmitEmailError : Throwable() {
    object EmailAlreadyInUse : SubmitEmailError()
    object NetworkError : SubmitEmailError()
}

interface SchedulerFacade {
    val main: Scheduler
    val background: Scheduler
}
