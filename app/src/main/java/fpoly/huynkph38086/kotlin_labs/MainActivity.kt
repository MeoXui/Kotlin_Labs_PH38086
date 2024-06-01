package fpoly.huynkph38086.kotlin_labs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import fpoly.huynkph38086.kotlin_labs.lab1.Lab1Activity
import fpoly.huynkph38086.kotlin_labs.lab2.Lab2Activity
import fpoly.huynkph38086.kotlin_labs.lab4.Lab4
import fpoly.huynkph38086.kotlin_labs.lab5.Lab5
import fpoly.huynkph38086.kotlin_labs.lab6.Lab6

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.lab1).setOnClickListener {
            startActivity(Intent(this, Lab1Activity::class.java))
        }

        findViewById<Button>(R.id.lab2).setOnClickListener {
            startActivity(Intent(this, Lab2Activity::class.java))
        }

        findViewById<Button>(R.id.lab4).setOnClickListener {
            startActivity(Intent(this, Lab4::class.java))
        }

        findViewById<Button>(R.id.lab5).setOnClickListener {
            startActivity(Intent(this, Lab5::class.java))
        }

        findViewById<Button>(R.id.lab6).setOnClickListener {
            startActivity(Intent(this, Lab6::class.java))
        }
    }
}