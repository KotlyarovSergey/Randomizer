package com.ksv.randomizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import com.ksv.randomizer.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        //binding.navigationContainer

        binding.toolbar.setNavigationOnClickListener {
            binding.navigationContainer.openDrawer(GravityCompat.START)
        }

        binding.leftMenu.setNavigationItemSelectedListener {
            var intent: Intent? = null
            when (it.itemId){
                R.id.itmNumbers ->
                    intent = Intent(this, ActivityNumbers::class.java)
                R.id.itmLists ->
                    intent = null
                R.id.itmDice ->
                    intent = null
            }

            binding.navigationContainer.closeDrawer(GravityCompat.START)
            if(intent != null)  startActivity(intent)

            true
        }


    }



}