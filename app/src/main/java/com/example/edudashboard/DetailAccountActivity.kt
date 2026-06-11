package com.example.edudashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.edudashboard.databinding.ActivityDetailAccountBinding

class DetailAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val name = intent.getStringExtra("EXTRA_NAME") ?: ""
        val nim = intent.getStringExtra("EXTRA_NIM") ?: ""
        val ipk = intent.getStringExtra("EXTRA_IPK") ?: ""

        binding.tvDisplayName.text = getString(R.string.display_name, name)
        binding.tvDisplayNim.text = getString(R.string.display_nim, nim)
        binding.tvDisplayIpk.text = getString(R.string.display_ipk, ipk)
    }
}