package com.example.yourkey

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.yourkey.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.inputButton.setOnClickListener { findKey(it) }
    }

    val sharpMajorMap: Map<Int, String> =
        mapOf(0 to "C dur", 1 to "G dur", 2 to "D dur", 3 to "A dur",
            4 to "E dur", 5 to "H dur", 6 to "Fis dur", 7 to "Cis dur")
    val sharpMinorMap: Map<Int, String> =
        mapOf(0 to "a moll", 1 to "e moll", 2 to "h moll", 3 to "fis moll",
            4 to "cis moll", 5 to "gis moll", 6 to "dis moll", 7 to "ais moll")
    val flatMajorMap: Map<Int, String> =
        mapOf(0 to "C dur", 1 to "F dur", 2 to "B dur", 3 to "Es dur",
            4 to "As dur", 5 to "Des dur", 6 to "Ges dur", 7 to "Ces dur")
    val flatMinorMap: Map<Int, String> =
        mapOf(0 to "a moll", 1 to "d moll", 2 to "g moll", 3 to "c moll",
            4 to "f moll", 5 to "b moll", 6 to "es moll", 7 to "as moll")

    private fun findKey(view: View) {
        binding.apply {
            val sharpNumber = sharpInput.text.toString().toInt()
            val flatNumber = flatInput.text.toString().toInt()

            sharpAnswerDurText.setText(sharpMajorMap[sharpNumber].toString())
            sharpAnswerMollText.setText(sharpMinorMap[sharpNumber].toString())
            flatAnswerDurText.setText(flatMajorMap[flatNumber].toString())
            flatAnswerMollText.setText(flatMinorMap[flatNumber].toString())
        }
        // Hide the keyboard.
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
