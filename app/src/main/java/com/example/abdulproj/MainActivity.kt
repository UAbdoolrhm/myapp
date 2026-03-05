package com.example.abdulproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Set a solid background color for the entire screen
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042) // Dark Navy Blue solid color
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        // Main Info Section (Image, Name, Title)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.pic),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Abdool Usman",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // White text for better contrast on dark background
            )

            Text(
                text = "Computer Engineering Student",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF3DDC84) // Android Green for contrast
            )

            Text(
                text = "Expert in AI prompting",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF3DDC84)
            )
        }

        // Contact Info Section (Bottom part)
        Column(
            modifier = Modifier.padding(bottom = 32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            ContactRow(icon = Icons.Rounded.Call, text = "09014644634")
            Spacer(modifier = Modifier.height(12.dp))
            ContactRow(icon = Icons.Rounded.Email, text = "asmanabdulrahman18@gmail.com")
        }
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3DDC84), // Android Green for icons
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.White // White text for visibility
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        Surface(color = Color(0xFF073042)) {
            BusinessCardApp()
        }
    }
}
