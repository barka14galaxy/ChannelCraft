
package com.barkapps.channelcraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                var tab by remember { mutableStateOf("Live TV") }
                var playlist by remember { mutableStateOf("") }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("ChannelCraft") }
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            listOf("Live TV", "Guide", "Recordings").forEach { item ->
                                NavigationBarItem(
                                    selected = tab == item,
                                    onClick = { tab = item },
                                    icon = {},
                                    label = { Text(item) }
                                )
                            }
                        }
                    }
                ) { padding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text(
                                "Your television, your way.",
                                style = MaterialTheme.typography.headlineSmall
                            )
                        }

                        item {
                            OutlinedTextField(
                                value = playlist,
                                onValueChange = { playlist = it },
                                label = { Text("M3U playlist URL") },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true
                            )
                        }

                        item {
                            Button(
                                onClick = {},
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Add Playlist")
                            }
                        }

                        item {
                            Text(
                                when (tab) {
                                    "Guide" ->
                                        "TV Guide\nProgram listings will appear here."
                                    "Recordings" ->
                                        "Recordings\nYour saved recordings will appear here."
                                    else ->
                                        "Live TV\nAdd a playlist to get started."
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
