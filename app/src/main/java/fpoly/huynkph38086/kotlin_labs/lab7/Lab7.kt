package fpoly.huynkph38086.kotlin_labs.lab7

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import fpoly.huynkph38086.kotlin_labs.lab6.activity.MovieScreen
import fpoly.huynkph38086.kotlin_labs.ui.theme.Kotlin_LabsTheme

class Lab7 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_LabsTheme {
                Greeting9()
            }
        }
    }
}

@Composable
fun Greeting9() {
    val context = LocalContext.current
    val mainViewModel: MainViewModel = viewModel()
    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())
    Column {
        Button(onClick = { ContextCompat.startActivity(
            context,
            Intent(context, Bai2::class.java),
            null
        ) },
            modifier = Modifier
                .align(alignment = Alignment.End)
        ) {
            Text(text = "Bài 2 >")
        }

        Box(modifier = Modifier.weight(1f)){
            MovieScreen(moviesState.value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    Kotlin_LabsTheme {
        Greeting9()
    }
}