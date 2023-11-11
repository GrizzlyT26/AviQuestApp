package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment
import com.google.android.gms.maps.model.LatLng

class StreetViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_street_view)

        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)

        val streetViewPanoramaFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_street) as SupportStreetViewPanoramaFragment?

        streetViewPanoramaFragment?.getStreetViewPanoramaAsync{streetviewPonroma ->
            //streetviewPonroma.setPosition(LatLng(-26.19234235066633, 28.033021687956595))
            streetviewPonroma.setPosition(LatLng(latitude,longitude))
        }
    }
}