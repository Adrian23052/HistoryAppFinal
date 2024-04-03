package com.adrian.adrianshistoryappfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    private lateinit var searchbutton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        searchbutton = findViewById(R.id.searchButton)
        clearbutton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)

        searchbutton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            if (age != null && age in 20..100) {
                val famouspersonName = when (age) {
                    95 -> "Nelson Mandela was the first black president of South Africa"
                    84 -> "Isaac Newton was an author who was described in his time as a natural philosopher."
                    76 -> "Albert Einstein considered one of the greatest and most influential scientists of all time"
                    60 -> "Diego Maradona is widely regarded as one of the greatest players in the history of the sport"
                    80 -> "Donatello was an Italian sculptor of the Renaissance period."
                    99 -> "Leonardo Davinci was a famous painter, draughtsman, engineer, scientist, theorist, sculptor, and architect."
                    66 -> "Marie Curie was a Polish and naturalised-French physicist and chemist who conducted pioneering research on radioactivity"
                    52 -> "William Shakespeare known for his English playwright, poet and actor. He is widely regarded as the greatest writer in the English language and the world's pre-eminent dramatist"
                    36 -> "Bob Marley was a Jamaican reggae singer, guitarist, and songwriter. Considered one of the pioneers of the genre"
                    100 -> "Charlie Trippi was a American professional football player for the Chicago Cardinals of the National Football League from 1947 to 1955"

                    else -> null
                }

                val message = if (famouspersonName != null) "You are the same age as $famouspersonName"
                else "No Famous Person found within the entered age."
                resultTextView.text = message
            } else {
                resultTextView.text = "Invalid input. Please enter a valid age between 20 and 100"
            }
        }
        clearbutton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = ""
        }
    }
}
