package com.example.flightsearch

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import com.example.flightsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    fun initViews() = binding.apply {
        spinnerArrival.adapter =
            ArrayAdapter<String>(
                this@MainActivity,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.cities)
            )
        spinnerDeparture.adapter =
            ArrayAdapter<String>(
                this@MainActivity,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.cities)
            )
        editTextArrivalDate.setupDatePicker()
        editTextDepartureDate.setupDatePicker()
    }

    fun EditText.setupDatePicker() {
        setOnClickListener {
            DatePickerDialog(this@MainActivity).apply {
                setOnDateSetListener { _, year, month, dayOfMonth ->
                    val string = "$dayOfMonth.${month + 1}.$year"
                    setText(string)
                }
                show()
            }
        }
    }
}