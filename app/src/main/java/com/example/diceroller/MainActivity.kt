package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceRecipe:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        findViewById<Button>(R.id.done_button).setOnClickListener {
        addNickname(it)
        }

        diceImage = findViewById(R.id.dice_image)
        diceRecipe=findViewById(R.id.recipe_text)
    }

    private fun rollDice() {

        val randomInt = Random().nextInt(6)+1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.cake
            2 -> R.drawable.fish
            3 -> R.drawable.porridge
            4 -> R.drawable.meat
            5 -> R.drawable.sausage
            else -> R.drawable.shashlik
        }
        val stringResource= when (randomInt){
            1 -> R.string.recipe
            2 -> R.string.recipe2
            3 -> R.string.recipe3
            4 -> R.string.recipe4
            5 -> R.string.recipe5
            else -> R.string.recipe6

        }

        diceImage.setImageResource(drawableResource)
        diceRecipe.setText(stringResource)

    }
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.note_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
