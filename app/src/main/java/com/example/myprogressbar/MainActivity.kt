package com.example.myprogressbar

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprogressbar.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var gMap:GoogleMap
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }





//        val hexNumberRegex = run {
//            val digits = "0-9"
//            val hexDigits = "A-Fa-f"
//            val sign = "+-"
//
//            Regex("[$sign]?[$digits$hexDigits]+")
//        }
//
//        for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
//            println(match.value)
//        }

        binding.sharedPrefPageButt.setOnClickListener()
        {
            val intent= Intent(this,SharedPreferenceActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onMapReady(p0: GoogleMap) {
        gMap = p0
        val location = LatLng(8.5786624, 76.8811648)
        gMap.addMarker(MarkerOptions().position(location).title("Green Field Stadium"))
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }
}

