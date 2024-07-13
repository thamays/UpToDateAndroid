package com.thamays.uptodateandroid.unit_03.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val count: Int,
    @DrawableRes val imageResourceId: Int,
)
