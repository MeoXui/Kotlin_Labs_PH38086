package fpoly.huynkph38086.kotlin_labs.lab6.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fpoly.huynkph38086.kotlin_labs.ui.screens.CinemaSeatBookingScreen
import fpoly.huynkph38086.kotlin_labs.ui.theme.Kotlin_LabsTheme
import fpoly.huynkph38086.kotlin_labs.lab6.utils.createTheaterSeating

class Bai3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_LabsTheme {
                Greeting8()
            }
        }
    }
}

@Composable
fun Greeting8() {
    CinemaSeatBookingScreen(
        createTheaterSeating(
            totalRows = 12,
            totalSeatsPerRow = 9,
            aislePositionInRow = 4,
            aislePositionInColumn = 5
        ), totalSeatsPerRow = 9
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    Kotlin_LabsTheme {
        Greeting8()
    }
}