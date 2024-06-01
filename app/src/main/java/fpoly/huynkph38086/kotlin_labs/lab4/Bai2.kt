package fpoly.huynkph38086.kotlin_labs.lab4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import fpoly.huynkph38086.kotlin_labs.R
import fpoly.huynkph38086.kotlin_labs.lab4.ui.theme.Kotlin_LabsTheme

class Bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_LabsTheme {
                Greeting2()
            }
        }
    }
}

@Composable
fun Greeting2() {
    val context = LocalContext.current
    Column {
        Text(text = "Icon:")
        Icon(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Logo"
        )
        Text(text = "Horizontal Image List:")
        HorizontalImageList(listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
        ))
        Text(text = "Vertical Image List:")
        VerticalImageList(listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
        ))
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

@Composable
fun HorizontalImageList(imageList: List<Int>) {
    val scrollState = rememberScrollState()
    Row(modifier = Modifier
        .horizontalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        start = if (index == 0) 0.dp else 8.dp,
                        end = 8.dp
                    )
            )
        }
    }
}

@Composable
fun VerticalImageList(imageList: List<Int>) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        top = if (index == 0) 0.dp else 8.dp,
                        bottom = 8.dp
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Kotlin_LabsTheme {
        Greeting2()
    }
}