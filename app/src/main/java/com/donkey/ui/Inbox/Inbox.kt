package com.donkey.ui.Inbox

import android.graphics.fonts.Font
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.donkey.ui.theme.accentGreen

@ExperimentalAnimationApi
@Composable
fun Inbox(viewModel: InboxViewModel = viewModel()) {

    val inboxState by viewModel.inboxViewState.collectAsState()

    when (inboxState) {
        is InboxViewState.Loaded -> {
            LoadedItems(inboxItems = (inboxState as InboxViewState.Loaded).items)
        }
        is InboxViewState.Loading -> {
            LoadingItems()
        }
        is InboxViewState.Error -> {

        }
    }

}

@ExperimentalAnimationApi
@Composable
fun LoadedItems(inboxItems: List<InboxItemData>) {
    LazyColumn(
    ) {
        itemsIndexed(inboxItems) { index, items ->
            InboxItem()
            if (index < inboxItems.lastIndex) {
                InboxItemDivider()
            }
        }
    }
}

@Composable
fun LoadingItems() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun InboxItemDivider() {
    Image(
        painter = ColorPainter(Color.LightGray),
        contentDescription = null,
        modifier = Modifier.height(2.dp)
    )
}

@Preview
@Composable
fun InboxItem() {

    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            InboxItemImage("VP")
            InboxItemLoaValue()
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        ) {
            InboxItemTitle()
            InboxItemSubtitle()
            InboxItemDescription()
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            InboxItemStatus()
            InboxItemDate(Modifier.padding(top = 4.dp))
        }
    }

}

@Composable
fun InboxItemStatus() {
    Text(
        text = "ACCEPTED",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(accentGreen)
            .padding(horizontal = 4.dp, vertical = 2.dp)
    )
}

@Composable
fun InboxItemDate(modifier: Modifier) {
    Text(
        text = "2/27",
        fontSize = 14.sp,
        textAlign = TextAlign.End,
        modifier = modifier
    )
}

@Composable
fun InboxItemTitle(title: String = "Verifying Party Name") {
    Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun InboxItemSubtitle(subtitle: String = "Authentication request") {
    Text(text = subtitle, fontSize = 14.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun InboxItemDescription(description: String = mockDescription) {
    Text(
        text = description,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        fontSize = 14.sp
    )
}

@Composable
fun InboxItemImage(initials: String) {
    Box {
        InboxItemInitialsView(initials = initials)
    }
}

@Composable
fun InboxItemInitialsView(initials: String) {
    Box(Modifier.size(64.dp), contentAlignment = Alignment.Center) {
        InboxItemInitialsViewBackground()
        InboxItemInitialsViewInitials(initials)
    }
}

@Composable
fun InboxItemInitialsViewBackground() {
    Image(
        painter = ColorPainter(Color.Red),
        contentDescription = null,
        modifier = Modifier
            .clip(CircleShape)
    )
}

@Composable
fun InboxItemInitialsViewInitials(text: String = "VP") {
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    )
}

@Composable
fun InboxItemLoaValue() {
    Text(text = "Level 2", fontSize = 18.sp)
}

const val mockDescription =
    "You will need to enter your PIN and unlock with your face to approve or deny this request."