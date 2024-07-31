package com.thamays.uptodateandroid.unit_04.dynamic_navigation.ui

import com.thamays.uptodateandroid.unit_04.dynamic_navigation.data.local.LocalEmailsDataProvider
import com.thamays.uptodateandroid.unit_04.dynamic_navigation.data.Email
import com.thamays.uptodateandroid.unit_04.dynamic_navigation.data.MailboxType

data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    val currentMailbox: MailboxType = MailboxType.Inbox,
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    val isShowingHomepage: Boolean = true
) {
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}
