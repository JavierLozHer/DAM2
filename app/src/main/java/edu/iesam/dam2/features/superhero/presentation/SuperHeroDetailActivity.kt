package edu.iesam.dam2.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2.R
import edu.iesam.dam2.app.extensions.loadUrl
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroDetailActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)

        superHeroFactory = SuperHeroFactory(this )
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()

        getSuperHeroId()?.let { superHeroId ->
            viewModel.viewCreated(superHeroId)?.let { superHero ->
                bindData(superHero)
            }
        }
    }

    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superHero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.superHeroImage)
        imageView.loadUrl(superHero.image)
    }

    companion object {
        val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superHeroId: String): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superHeroId)
            return intent
        }
    }
}