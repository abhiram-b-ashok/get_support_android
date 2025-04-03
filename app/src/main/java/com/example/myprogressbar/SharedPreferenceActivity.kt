package com.example.myprogressbar

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprogressbar.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPreferenceBinding
    private val sharedPreferenceFileName = "shared preference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPreferenceFileName, Context.MODE_PRIVATE)
        binding.saveButton.setOnClickListener(View.OnClickListener {
            val id: Int = Integer.parseInt(binding.idValue.text.toString())
            val name: String = binding.nameValue.text.toString()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("id_key", id)
            editor.putString("name_key", name)
            editor.apply()
        })
        binding.viewButton.setOnClickListener(View.OnClickListener {
            val sharedId = sharedPreferences.getInt("id_key", 0)
            val sharedName = sharedPreferences.getString("name_key", "default")
            if (sharedId.equals(0) && sharedName.equals("default")) {
                binding.apply {
                    spNameValue.text = "defaultName"
                    spIdValue.text = "defaultId"
                }
            } else {
                binding.apply {
                    spNameValue.text = sharedName
                    spIdValue.text = sharedId.toString()
                }

            }
        })
        binding.clearButton.setOnClickListener(View.OnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            binding.apply {
                spNameValue.text = " "
                spIdValue.text = " "
            }
        })

    }
}