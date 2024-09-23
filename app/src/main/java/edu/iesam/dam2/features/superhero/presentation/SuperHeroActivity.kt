package edu.iesam.dam2.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.dam2.R

class SuperHeroActivity : AppCompatActivity() {

    private val superHeroFactory: SuperHeroFactory = SuperHeroFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero2)

        val viewModel = superHeroFactory.buildViewModel()
        val superHeroes = viewModel.viewCreated()

        Log.d("@dev", superHeroes.toString())
    }
}