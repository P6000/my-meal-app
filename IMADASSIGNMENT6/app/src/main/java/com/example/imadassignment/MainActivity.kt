package com.example.imadassignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI elements
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val suggestionOutput = findViewById<TextView>(R.id.suggestionOutput)

        // Handle "Suggest Meal" button click
        suggestButton.setOnClickListener {
            val inputTime = timeInput.text.toString().trim().lowercase()

            // Check if input is empty
            if (inputTime.isEmpty()) {
                suggestionOutput.text = "Please enter a valid time of day."
                return@setOnClickListener
            }

            // Use if statements to match input and provide meal suggestions
            val suggestion = when (inputTime) {
                "morning" -> "Suggested Meal: Breakfast (e.g., Eggs)"
                "mid-morning" -> "Suggested Meal: Light snack (e.g., Fruit)"
                "afternoon" -> "Suggested Meal: Lunch (e.g., Sandwich)"
                "mid-afternoon" -> "Suggested Meal: Light snack (e.g., Yogurt)"
                "dinner" -> "Suggested Meal: Main course (e.g., Pasta)"
                "after dinner" -> "Suggested Meal: Dessert (e.g., Ice Cream)"
                else -> "Invalid time of day. Try: Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner, After Dinner."
            }

            // Display suggestion
            suggestionOutput.text = suggestion
        }

        // Handle "Reset" button click
        resetButton.setOnClickListener {
            timeInput.setText("")
            suggestionOutput.text = "Your meal suggestion will appear here."
        }
    }
}


