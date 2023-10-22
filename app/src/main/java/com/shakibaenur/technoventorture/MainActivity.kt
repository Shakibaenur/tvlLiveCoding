package com.shakibaenur.technoventorture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shakibaenur.technoventorture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView
    private var currentRoute: Int = -99
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.dashboardNavHostFragment) as NavHostFragment

        bottomNav = binding.bottomNavigationView
        navController = navHostFragment.navController
        setBottomNavSelectListener()
        setContentView(binding.root)
    }

    private fun setBottomNavSelectListener() {
        bottomNav.setOnItemSelectedListener {

            if (currentRoute != it.itemId) {
                currentRoute = it.itemId
                when (it.itemId) {

                    R.id.navHome -> {
                        navController.navigate(R.id.homeFragment)
                        true
                    }

                    R.id.navDetails -> {
                        navController.navigate(R.id.detailsFragment)
                        true
                    }

                    else -> {
                        true
                    }
                }

            } else {
                false
            }
        }
    }
}