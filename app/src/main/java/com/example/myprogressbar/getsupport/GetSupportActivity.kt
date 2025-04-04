package com.example.myprogressbar.getsupport

import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprogressbar.R
import com.example.myprogressbar.databinding.ActivityGetSupportBinding

class GetSupportActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetSupportBinding
    lateinit var bottomSheetFragment: BottomSheetFragment
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

        val sharedPreferences: SharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE)
        binding.apply {
            reasonValue.setOnClickListener {
                bottomSheetFragment = BottomSheetFragment()
                bottomSheetFragment.show(supportFragmentManager, "BottomSheetDialog")

            }
            sendButton.setOnClickListener()
            {

            }
            sendButton.setOnClickListener (View.OnClickListener {
                if (checkEmpty()) {


                val name = nameValue.text.toString()
                val mail = mailValue.text.toString()
                val reason = reasonValue.text.toString()
                val message = messageValue.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("mail", mail)
                editor.putString("reason", reason)
                editor.putString("message", message)
                editor.apply()
                sendOutput.visibility = View.VISIBLE
                }
            })

            nameValue.addTextChangedListener {nameError.visibility = View.GONE}
            nameValue.addTextChangedListener {nameError.visibility = View.GONE}
            nameValue.addTextChangedListener {nameError.visibility = View.GONE}
            nameValue.addTextChangedListener {nameError.visibility = View.GONE}


        }
        val sharedName = sharedPreferences.getString("name", "")
        val sharedMail = sharedPreferences.getString("mail", "")
        val sharedReason = sharedPreferences.getString("reason", "")
        val sharedMessage = sharedPreferences.getString("message", "")
        binding.apply {
            nameValue.setText(sharedName)
            mailValue.setText(sharedMail)
            reasonValue.setText(sharedReason)
            messageValue.setText(sharedMessage)
            }

    }

    private fun checkEmpty(): Boolean {
        var entered = true
        if (binding.nameValue.text.isEmpty()) {
            entered = false
            binding.nameError.visibility = View.VISIBLE

        }
        if (binding.mailValue.text.isEmpty()) {
            entered = false
            binding.mailError.visibility = View.VISIBLE

        }
        if (binding.reasonValue.text.isEmpty()) {
            entered = false
            binding.reasonError.visibility = View.VISIBLE

        }
        if (binding.messageValue.text.isEmpty()) {
            entered = false
            binding.messageError.visibility = View.VISIBLE

        }

        return entered

    }
    fun setSelectedValue(value: String) {
        binding.reasonValue.setText(value)
    }
}