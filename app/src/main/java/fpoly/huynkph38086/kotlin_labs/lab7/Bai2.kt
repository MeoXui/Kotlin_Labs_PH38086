package fpoly.huynkph38086.kotlin_labs.lab7

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import fpoly.huynkph38086.kotlin_labs.ui.theme.Kotlin_LabsTheme

class Bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_LabsTheme {
                Greeting10()
            }
        }
    }
}

@Composable
fun Greeting10() {
    val context = LocalContext.current
    ScreenNavigation()
    Button(onClick = {
            ContextCompat.startActivity(
                context,
                Intent(context, Bai3::class.java),
                null
            )
        }
    ) {
        Text(text = "Bai 3 >")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview10() {
    Kotlin_LabsTheme {
        Greeting10()
    }
}