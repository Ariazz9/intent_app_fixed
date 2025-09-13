package com.example.intenapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intenapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        val nim = intent.getStringExtra(MainActivity.EXTRA_NIM)
        val prodi = intent.getStringExtra(MainActivity.EXTRA_PRODI)
        val address = intent.getStringExtra(MainActivity.EXTRA_ADDRESS)
        val quote = intent.getStringExtra(MainActivity.EXTRA_QUOTE)


        if (!name.isNullOrEmpty()) binding.txtName.text = "Nama: $name"
        if (!nim.isNullOrEmpty()) binding.txtNim.text = "NIM: $nim"
        if (!prodi.isNullOrEmpty()) binding.txtProdi.text = "Prodi: $prodi"
        if (!address.isNullOrEmpty()) binding.txtAddress.text = "Alamat: $address"
        if (!quote.isNullOrEmpty()) binding.txtQuote.text = "Quote: $quote"
    }
}
