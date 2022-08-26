package com.mb.compose_jam_8_25_22.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mb.cs410j.compose_jam_8_25_22.ui.theme.JamTheme

@Preview(showSystemUi = true, device = Devices.PIXEL_3)
@Composable
fun PreviewTabbedMainScreen() {
    JamTheme {
        TabbedMainScreen()
    }
}

@Composable
fun TabbedMainScreen() {

    var currentScreen by remember { mutableStateOf(1) }

    Column {

        // Body
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            when (currentScreen) {
                1 -> HomeScreen()
                2 -> SearchScreen()
                3 -> ShopScreen()
                4 -> UserScreen()
            }
        }
        Surface(color = MaterialTheme.colorScheme.secondary) {

            // Bottom Bar
            Row(
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { currentScreen = 1 }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterHorizontally)
                    ) {

                        Icon(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            imageVector = Icons.Rounded.Home,
                            contentDescription = "Home Icon"
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { currentScreen = 2 }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterHorizontally)
                    ) {

                        Icon(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { currentScreen = 3 }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterHorizontally)
                    ) {

                        Icon(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            imageVector = Icons.Rounded.ShoppingCart,
                            contentDescription = "Shopping Cart Icon"
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { currentScreen = 4 }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterHorizontally)
                    ) {

                        Icon(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            imageVector = Icons.Rounded.Person,
                            contentDescription = "User Icon"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally)
        ) {

            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Rounded.Home,
                contentDescription = "Home Icon"
            )
        }
    }
}

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally)
        ) {

            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon"
            )
        }
    }
}

@Composable
fun ShopScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally)
        ) {

            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = "Shopping Cart Icon"
            )
        }
    }
}

@Composable
fun UserScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally)
        ) {

            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Rounded.Person,
                contentDescription = "User Icon"
            )
        }
    }
}
