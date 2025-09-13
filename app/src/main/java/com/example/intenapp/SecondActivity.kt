package com.example.intenapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intenapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtName.text = "Nama: ${intent.getStringExtra(MainActivity.EXTRA_NAME)}"
        binding.txtNim.text = "NIM: ${intent.getStringExtra(MainActivity.EXTRA_NIM)}"
        binding.txtProdi.text = "Prodi: ${intent.getStringExtra(MainActivity.EXTRA_PRODI)}"
        binding.txtAddress.text = "Alamat: ${intent.getStringExtra(MainActivity.EXTRA_ADDRESS)}"
        binding.txtQuote.text = "Quote: ${intent.getStringExtra(MainActivity.EXTRA_QUOTE)}"
    }
}
