package com.example.quotesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.quotesapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationButton: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNavigationBar()
    }

    private fun setUpBottomNavigationBar() {

        val navController = Navigation.findNavController(this, R.id.newsNavHostFragment)
        navigationButton = binding.bottomNavigationView

        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(navigationButton, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.newsNavHostFragment)

        return navController.navigateUp() or super.onSupportNavigateUp()
    }
}