package edu.iesam.dam2.features.superhero.presentation

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2.R
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroesActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero)

        superHeroFactory = SuperHeroFactory(this )
        viewModel = superHeroFactory.buildViewModel()

        val superHeroes = viewModel.viewCreated()

        bindData(superHeroes)
    }

    private fun bindData(superHeroes: List<SuperHero>) {
        findViewById<TextView>(R.id.superHero_id_1).text = superHeroes[0].id
        findViewById<TextView>(R.id.superHero_name_1).text = superHeroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToSuperHeroDetail("1")
        }

        findViewById<TextView>(R.id.superHero_id_2).text = superHeroes[1].id
        findViewById<TextView>(R.id.superHero_name_2).text = superHeroes[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToSuperHeroDetail("2")
        }

        findViewById<TextView>(R.id.superHero_id_3).text = superHeroes[2].id
        findViewById<TextView>(R.id.superHero_name_3).text = superHeroes[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToSuperHeroDetail("3")
        }
    }

    private fun navigateToSuperHeroDetail(superHeroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
    }


}