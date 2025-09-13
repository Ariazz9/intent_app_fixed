package com.example.intenapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intenapp.databinding.ActivityInputAddressBinding

class InputDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityInputAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityInputAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnSubmit.setOnClickListener {
                val resultIntent = Intent()
                resultIntent.putExtra(MainActivity.EXTRA_NAME, edtNama.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_NIM, edtNim.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_PRODI, edtProdi.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_ADDRESS, edtAddress.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_QUOTE, edtQuote.text.toString())
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}