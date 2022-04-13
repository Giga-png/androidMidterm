package btu.midterm.giga_sulkhanishvili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var cardNumberPart1: EditText
    private lateinit var cardNumberPart2: EditText
    private lateinit var cardNumberPart3: EditText
    private lateinit var cardNumberPart4: EditText


    private lateinit var dateMonth: EditText
    private lateinit var dateYear: EditText

    private lateinit var cvv: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardNumberPart1 = findViewById(R.id.cardNumberPart1)
        cardNumberPart2 = findViewById(R.id.cardNumberPart2)
        cardNumberPart3 = findViewById(R.id.cardNumberPart3)
        cardNumberPart4 = findViewById(R.id.cardNumberPart4)

        dateMonth = findViewById(R.id.dateMonth)
        dateYear = findViewById(R.id.dateYear)

        cvv = findViewById(R.id.cvv)

        findViewById<Button>(R.id.payBtn).setOnClickListener {
            if (cardNumberPart1.text.toString().isEmpty()) {
                cardNumberPart1.error = "Empty"
            }
            if (cardNumberPart2.text.toString().isEmpty()) {
                cardNumberPart2.error = "Empty"
            }
            if (cardNumberPart3.text.toString().isEmpty()) {
                cardNumberPart3.error = "Empty"
            }
            if (cardNumberPart4.text.toString().isEmpty()) {
                cardNumberPart4.error = "Empty"
            }

            val cardNumber =
                cardNumberPart1.text.toString() + cardNumberPart2.text.toString() + cardNumberPart3.text.toString() + cardNumberPart4.text.toString()

            if (cardNumber.length != 16) {
                listOf(
                    cardNumberPart1,
                    cardNumberPart2,
                    cardNumberPart3,
                    cardNumberPart4,
                ).forEach { it.error = "" }
                return@setOnClickListener
            }

            if (dateMonth.text.toString().toInt() > 12) {
                dateMonth.error = "invalid month"
                return@setOnClickListener
            }

            if (dateYear.text.toString().toInt() < 2022) {
                dateYear.error = "invalid year"
                return@setOnClickListener
            }

            if (cvv.text.toString().isEmpty()) {
                cvv.error = ""
            }

            if (cvv.text.toString().length != 3) {
                cvv.error = ""
            }

            Toast.makeText(this, "მიმდინარეობს გადახდა", Toast.LENGTH_LONG).show()
        }

    }
}