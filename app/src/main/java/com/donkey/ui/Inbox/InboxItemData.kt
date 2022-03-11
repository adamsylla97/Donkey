package com.donkey.ui.Inbox

class InboxItemData(
    val title: String,
    val subtitle: String,
    val description: String,
    val createDate: String,
    val status: InboxItemStatus
)

enum class InboxItemStatus(value: String) {
    ACCEPTED("accepted"),
    EXPIRED("expired")
}