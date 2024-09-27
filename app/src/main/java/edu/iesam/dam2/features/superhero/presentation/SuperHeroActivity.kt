package edu.iesam.dam2.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2.R
import edu.iesam.dam2.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {

    private val superHeroFactory: SuperHeroFactory = SuperHeroFactory()
    private val viewModel: SuperHeroViewModel = superHeroFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero2)

        val superHeroes = viewModel.viewCreated()

        bindData(superHeroes)
        testXml()
    }

    private fun bindData(superHeroes: List<SuperHero>) {
        findViewById<TextView>(R.id.superHero_id_1).text = superHeroes[0].id
        findViewById<TextView>(R.id.superHero_name_1).text = superHeroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            superHeroSelect(superHeroes, 0)
        }

        findViewById<TextView>(R.id.superHero_id_2).text = superHeroes[1].id
        findViewById<TextView>(R.id.superHero_name_2).text = superHeroes[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            superHeroSelect(superHeroes, 1)
        }

        findViewById<TextView>(R.id.superHero_id_3).text = superHeroes[2].id
        findViewById<TextView>(R.id.superHero_name_3).text = superHeroes[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            superHeroSelect(superHeroes, 2)
        }
    }

    private fun superHeroSelect(superHeroes: List<SuperHero>, superHeroNum: Int) {
        val superHero: SuperHero? = viewModel.itemSelected(superHeroes[superHeroNum].id)
        superHero?.let {
            Log.d("@dev", "Super Heroe seleccionado: ${it.name}")
        }
    }

    private fun testXml() {
        val xmlDataSource = SuperHeroXmlLocalDataSource( this )
        val superHero = viewModel.itemSelected("1")

        superHero?.let {
            xmlDataSource.save(it)
        }

        val superHeroXml = xmlDataSource.find()
        Log.d("@dev", superHeroXml.toString())

        xmlDataSource.delete()
    }
}