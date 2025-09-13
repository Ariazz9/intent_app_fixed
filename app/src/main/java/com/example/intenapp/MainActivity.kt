package com.example.intenapp
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intenapp.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    // 1. Bikin UI untuk MainActivity > 1 button untuk navigasi ke SecondActivity
    // 2. Bikin UI untuk SecondActivity > 1 TextView menampilkan welocom ${name}
    // 3. Gunakan intent untuk navigasi dan kirim data

    private var newName: String = ""
    private var newNim: String = ""
    private var newProdi: String = ""
    private var newAddress: String = ""
    private var newQuote: String = ""

    lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_NAME = "data_nama"
        const val EXTRA_NIM = "data_nim"
        const val EXTRA_PRODI = "data_prodi"
        const val EXTRA_ADDRESS = "data_address"
        const val EXTRA_QUOTE = "data_quote"
    }

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            newName = data?.getStringExtra(EXTRA_NAME) ?: ""
            newNim = data?.getStringExtra(EXTRA_NIM) ?: ""
            newProdi = data?.getStringExtra(EXTRA_PRODI) ?: ""
            newAddress = data?.getStringExtra(EXTRA_ADDRESS) ?: ""
            newQuote = data?.getStringExtra(EXTRA_QUOTE) ?: ""
            with(binding) {
                binding.txtName.text = "Nama: $newName"
                binding.txtNim.text = "NIM: $newNim"
                binding.txtProdi.text = "Prodi: $newProdi"

            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MAINACTIVITY", "onCreate dipanggil")

        // handle binding
        with(binding) {
            btnToSecondActivity.setOnClickListener {
                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra(EXTRA_NAME, newName)
                    putExtra(EXTRA_NIM, newNim)
                    putExtra(EXTRA_PRODI, newProdi)
                    putExtra(EXTRA_ADDRESS, newAddress)
                    putExtra(EXTRA_QUOTE, newQuote)
                }
                startActivity(intentToSecondActivity)
            }


            btnToThirdActivity.setOnClickListener {
                val intentToThirdActivity = Intent(this@MainActivity, InputDataActivity::class.java).apply {
                    putExtra(EXTRA_NAME, newName)
                    putExtra(EXTRA_NIM, newNim)
                    putExtra(EXTRA_PRODI, newProdi)
                    putExtra(EXTRA_ADDRESS, newAddress)
                    putExtra(EXTRA_QUOTE, newQuote)
                }
                launcher.launch(intentToThirdActivity)
            }

        }
        }



    override fun onStart() {
        super.onStart()
        Log.d("MAINACTIVITY", "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MAINACTIVITY", "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAINACTIVITY", "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MAINACTIVITY", "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAINACTIVITY", "onDestroy dipanggil")
    }
}