package com.example.project1wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val input1 = findViewById<TextView>(R.id.textViewCol2Row1)
        val input1Check = findViewById<TextView>(R.id.textViewCol2Row2)
        val input2 = findViewById<TextView>(R.id.textViewCol2Row3)
        val input2Check = findViewById<TextView>(R.id.textViewCol2Row4)
        val input3 = findViewById<TextView>(R.id.textViewCol2Row5)
        val input3Check = findViewById<TextView>(R.id.textViewCol2Row6)

        val solution = findViewById<TextView>(R.id.textViewWordleSolution)


        val guessButton = findViewById<Button>(R.id.guessButton)
        val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        var tryCount = 1

        fun checkGuess(guess: String) : String {
            var result = ""

            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        } // end checkGuess()


        guessButton.setOnClickListener {
            val inputField = findViewById<EditText>(R.id.inputField)
                if (tryCount == 1) {

                    input1.text = inputField.text.toString().uppercase()
                    input1Check.text = checkGuess(input1.text.toString())
                    inputField.getText().clear()

                } else if (tryCount == 2) {
                    input2.text = inputField.text.toString().uppercase()
                    input2Check.text = checkGuess(input2.text.toString())
                    inputField.getText().clear()


                } else if (tryCount == 3) {
                    input3.text = inputField.text.toString().uppercase()
                    input3Check.text = checkGuess(input3.text.toString())
                    solution.text = wordToGuess.toString()
                    inputField.getText().clear()
                }

            if (tryCount <= 3) {
                tryCount++
            } else {
                val toast = Toast.makeText(applicationContext, "You exceeded 3 guesses!",
                Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                toast.show()
            }
        } // end guessButton.setOnclickListener


    }

}