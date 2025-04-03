package com.example.myprogressbar.getsupport

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprogressbar.R
import com.example.myprogressbar.databinding.ActivityGetSupportBinding

class GetSupportActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetSupportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGetSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.sendButton.setOnClickListener()
        {
            if(checkEmpty())
            {
                Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun checkEmpty():Boolean
    {
        var entered = true
        if(binding.nameValue.text.isEmpty())
        {
            entered = false
            binding.nameError.visibility = View.VISIBLE

        }
         if(binding.mailValue.text.isEmpty())
        {
            entered = false
            binding.mailError.visibility = View.VISIBLE

        }
         if(binding.reasonValue.text.isEmpty())
        {
            entered = false
            binding.reasonError.visibility = View.VISIBLE

        }
         if(binding.messageValue.text.isEmpty())
        {
            entered = false
            binding.messageError.visibility = View.VISIBLE

        }

        return entered

    }
}