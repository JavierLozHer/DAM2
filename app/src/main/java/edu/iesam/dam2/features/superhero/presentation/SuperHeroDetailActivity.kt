package edu.iesam.dam2.features.superhero.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2.R

class SuperHeroDetailActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)

        superHeroFactory = SuperHeroFactory(this )
        viewModel = superHeroFactory.buildViewModel()


    }
}