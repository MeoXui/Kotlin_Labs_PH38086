package fpoly.huynkph38086.kotlin_labs.lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import fpoly.huynkph38086.kotlin_labs.R
import fpoly.huynkph38086.kotlin_labs.lab4.ui.theme.Kotlin_LabsTheme

class Lab4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_LabsTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var un by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = un,
            onValueChange = { un = it },
            label = { Text(text = "Username", fontSize = 16.sp) },
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = pw,
            onValueChange = { pw = it },
            label = { Text(text = "Password", fontSize = 16.sp) },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            if (un.isNotBlank() && pw.isNotBlank()) {
                ContextCompat.startActivity(
                    context,
                    Intent(context, Bai2::class.java),
                    null
                )
                Toast.makeText(context, "Đăng nhập thành công",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    context, "Vui lòng không để trống",
                    Toast.LENGTH_LONG
                ).show()
            }},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White)
        ) {
            Text(text = "Login", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_LabsTheme {
        Greeting()
    }
}