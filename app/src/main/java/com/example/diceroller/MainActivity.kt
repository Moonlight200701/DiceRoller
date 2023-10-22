package com.example.diceroller

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)
        val resultTextView3: TextView = findViewById(R.id.textView3)
        rollButton.setOnClickListener {
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
//            rollDice()
//            val notif = Toast.makeText(
//                this,
//                "Dice Rolled! :>",
//                Toast.LENGTH_SHORT
//            ) //Toast: quick little message for the user
//            notif.show()

            object : CountDownTimer(5000, 100) {
                override fun onTick(millisUntilFinished: Long) {
                    resultTextView3.text = "Rolling!"
                    rollButton.isVisible = false
                    rollDice()
                }

                override fun onFinish() {
                    resultTextView3.text = "Done :>"
                    rollButton.isVisible = true
                }
            }.start()

        }
        rollDice()
    }



    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView.text = diceRoll.toString()
        resultTextView2.text = diceRoll2.toString()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableResource = when(diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }

        val drawableResource2 = when(diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
        print(diceImage2.contentDescription)
    }

}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
