package fpoly.huynkph38086.kotlin_labs.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    //GreetingCard("Hello, Nguyễn Khánh Huy - PH38086")
    CounterCard()
    //GD_Dang_Nhap()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting()
}

@Composable
fun GreetingCard(msg: String) {
    var text by remember { mutableStateOf(msg) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCard(msg = text)
        Button(onClick = { text = "Hi!" }) {
            Text("Say Hi!")
        }
    }
}

@Composable
fun MessageCard(msg: String) {
    Text(
        text = msg,
        modifier = Modifier
            .padding(0.dp, 16.dp)
            .fillMaxWidth(),
        color = Color.DarkGray,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CounterCard() {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCard("You have clicked the button $count times.")
        Button(onClick = { count++ }) {
            Text("Click me")
        }
    }
}

@Composable
fun GD_Dang_Nhap() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var un by remember { mutableStateOf("") }
        var pw by remember { mutableStateOf("") }
        Text(
            text = "Đăng nhập",
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxWidth(),
            color = Color.DarkGray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        TextField(
            value = un,
            onValueChange = {un = it},
            placeholder = { Text("Tên đăng nhập") },
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = pw,
            onValueChange = {pw = it},
            placeholder = { Text("Mật khẩu") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxWidth()
        )
        Button(onClick = { }) {
            Text("Đăng nhập")
        }
    }
}