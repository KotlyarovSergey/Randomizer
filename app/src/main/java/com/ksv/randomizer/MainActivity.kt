package com.ksv.randomizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import com.ksv.randomizer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.navigationContainer

        binding.toolbar.setNavigationOnClickListener {
            // открфваем меню
            binding.navigationContainer.openDrawer(GravityCompat.START)
        }

        binding.leftMenu.setNavigationItemSelectedListener {
            binding.tvTest.text = "Listenter"
//            var intent: Intent? = null
//            when (it.itemId){
//                R.id.itmNumbers ->
//                    intent = Intent(this, ActivityNumbers::class.java)
//                R.id.itmLists ->
//                    //intent = null
//                    binding.tvTest.text = "itmLists"
//                R.id.itmDice ->
//                    intent = null
//            }
//            binding.navigationContainer.closeDrawer(GravityCompat.START)
//            startActivity(intent)
            val intent = Intent(this, ActivityNumbers::class.java)
            startActivity(intent)
            true
        }


    }

    private fun openActivityNumbers(){
        val intent = Intent(this, ActivityNumbers::class.java)
        startActivity(intent)
    }

    fun onClickItmNumbers(view: View){
        val intent = Intent(this, ActivityNumbers::class.java)
        startActivity(intent)
    }
    fun onClickItmLists(view: View){
//        val intent = Intent(this,  ::class.java)
//        startActivity(intent)
    }
    fun onClickItmDice(view: View){
//        val intent = Intent(this,  ::class.java)
//        startActivity(intent)
    }




}