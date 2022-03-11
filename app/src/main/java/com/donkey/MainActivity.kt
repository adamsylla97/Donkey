package com.donkey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.donkey.navigation.Screen
import com.donkey.ui.Inbox.Inbox
import com.donkey.ui.theme.DonkeyTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DonkeyTheme {
               val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Inbox.route
                ) {
                    composable(route = Screen.Inbox.route) {
                        Inbox()
                    }
                }
            }
        }
    }
}