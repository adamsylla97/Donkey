package com.donkey.ui.Inbox

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InboxViewModel : ViewModel() {

    private val _inboxViewState: MutableStateFlow<InboxViewState> = MutableStateFlow(
        InboxViewState.Loading
    )
    val inboxViewState = _inboxViewState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(5000)
            _inboxViewState.value = InboxViewState.Loaded(
                listOf(
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED),
                    InboxItemData("test1", "test2", "test3", "2/27", InboxItemStatus.ACCEPTED)
                )
            )
        }
    }

}

sealed class InboxViewState {
    class Loaded(val items: List<InboxItemData>) : InboxViewState()
    object Loading : InboxViewState()
    object Error : InboxViewState()
}