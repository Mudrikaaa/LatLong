package com.example.latlong


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    val context = LocalContext.current

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text(text = "Latitude", fontSize = 16.sp) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text(text = "Longitude", fontSize = 16.sp) }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    // Display inputs
                    val displayText = "Latitude: $latitude, Longitude: $longitude"
                    showToast(context, "Your inputs are recorded")
                }
            ) {
                Text(text = "Display Inputs", fontSize = 16.sp)
            }
        }
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}