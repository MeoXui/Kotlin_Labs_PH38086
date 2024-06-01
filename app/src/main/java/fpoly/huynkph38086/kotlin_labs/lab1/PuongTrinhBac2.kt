package fpoly.huynkph38086.kotlin_labs.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import fpoly.huynkph38086.kotlin_labs.R
import fpoly.huynkph38086.kotlin_labs.lab1.lab1.Companion.A2B1C0

class PuongTrinhBac2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_puong_trinh_bac2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edA = findViewById<EditText>(R.id.a)
        val edB = findViewById<EditText>(R.id.b)
        val edC = findViewById<EditText>(R.id.c)

        findViewById<Button>(R.id.btn_ketqua).setOnClickListener {
            if (edA.text.isEmpty()) edA.setText("0")
            if (edB.text.isEmpty()) edB.setText("0")
            if (edC.text.isEmpty()) edC.setText("0")

            val a = edA.text.toString().toDouble()
            val b = edB.text.toString().toDouble()
            val c = edC.text.toString().toDouble()

            findViewById<TextView>(R.id.kq).text = A2B1C0(a, b, c)
        }
    }
}