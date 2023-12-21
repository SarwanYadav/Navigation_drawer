package com.example.navigation01

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Message
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    lateinit var toolbar: Toolbar
    lateinit var navigationview: NavigationView
    lateinit var drawerlayout: DrawerLayout

    var toggel: ActionBarDrawerToggle? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerlayout = findViewById(R.id.drawable)




        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)


        navigationview = findViewById<View>(R.id.navigationview) as NavigationView


        toggel = ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close)
        drawerlayout!!.addDrawerListener(toggel!!)
        toggel!!.syncState()


        navigationview.setNavigationItemSelectedListener { item: MenuItem? ->

            when (item!!.itemId) {

                R.id.home -> {
                  intent= Intent(this,HomePage:: class.java)
                    startActivity(intent)


                }


                R.id.message-> {
                    val smsIntent = Intent(Intent.ACTION_VIEW)
                    smsIntent.data = Uri.parse("sms:")
                }

            }
            true

        }
    }
}
