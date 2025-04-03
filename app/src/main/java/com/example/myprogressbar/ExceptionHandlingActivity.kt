package com.example.myprogressbar

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprogressbar.databinding.ActivityExceptionHandlingBinding

class ExceptionHandlingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExceptionHandlingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExceptionHandlingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name: String? = null //NullPointerException
        try {
            Log.i("NullException", "${name!!.length}")
        } catch (e: NullPointerException) {
            Log.i("NullException", "name can't be null")
        }


        val array = arrayOf("qw", "er", "ty", "ui", "op") //IndexOutOfBoundsException
        try {
            Log.i("IndexException", array[7])
        } catch (e: IndexOutOfBoundsException) {
            Log.i("IndexException", "element not found")
        }


        fun votersRegistration(age: Int) //IllegalArgumentException
        {
            if (age > 18) {
                Log.i("IllegalException", "you are eligible to vote")
            }
            throw IllegalArgumentException("age must be larger than 18")
        }
        try {
            votersRegistration(12)
        } catch (e: IllegalArgumentException) {
            Log.i("IllegalException", "${e.message}")
        } finally {
            Log.i("IllegalException", "In India age must be above 18 to vote")
        }


        fun checkingPressure(value: Int) {
            if (value <0 ) {
               throw IllegalArgumentException("Pressure must be greater than 0")
            }
        }
        try {
            checkingPressure(-3)
        }catch (e:IllegalArgumentException)
        {
            Log.i("IllegalExceptionPressure", "${e.message}")
        }

}
}