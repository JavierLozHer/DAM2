package edu.iesam.dam2.features.superhero.data.local

import android.content.Context
import edu.iesam.dam2.R
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml_superheroes), Context.MODE_PRIVATE)

    fun save(superHero: SuperHero) {
        sharedPref.edit().apply{
            putString("id", superHero.id)
            putString("name", superHero.name)
            putString("slug", superHero.slug)
            apply()
        }
    }

    fun find(): SuperHero {
        sharedPref.apply {
            return SuperHero(
                getString("id", "")!!,
                getString("name", "")!!,
                getString("slug", "")!!
            )
        }
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }
}