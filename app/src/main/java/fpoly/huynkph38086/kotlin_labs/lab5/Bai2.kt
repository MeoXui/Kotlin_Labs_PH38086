package fpoly.huynkph38086.kotlin_labs.lab5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import fpoly.huynkph38086.kotlin_labs.R
import fpoly.huynkph38086.kotlin_labs.ui.theme.Kotlin_LabsTheme

class Bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_LabsTheme {
                Greeting5()
            }
        }
    }
}

@Composable
fun Greeting5() {
    LightSwitch()
}

@Composable
fun LightSwitch() {
    val context = LocalContext.current
    val isChecked = remember { mutableStateOf(false) }
    val c = if(isChecked.value) Color.White else Color.Black
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(c),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isChecked.value) {
            Image(
                painter = painterResource(id = R.drawable.light_on),
                contentDescription = "Light is On",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.light_off),
                contentDescription = "Light is Off",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Switch(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Green,
                uncheckedThumbColor = Color.Gray,
                checkedTrackColor = Color.Green.copy(alpha = 0.5f),
                uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f),
                checkedBorderColor = Color.Green.copy(alpha = 0.75f),
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            ContextCompat.startActivity(
                context,
                Intent(context, Bai3::class.java),
                null
            )
        }) {
            Text(text = "Bai 3 >")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    Kotlin_LabsTheme {
        Greeting5()
    }
}