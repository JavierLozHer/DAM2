package edu.iesam.dam2.features.superhero.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2.R
import edu.iesam.dam2.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml_superheroes), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun save(superHero: SuperHero) {
        val editor = sharedPref.edit()
        editor.putString(superHero.id, gson.toJson(superHero))
        editor.apply()
    }

    fun saveAll(superHeroes: List<SuperHero>) {
        val editor = sharedPref.edit()
        superHeroes.forEach { superHero ->
            editor.putString(superHero.id, gson.toJson(superHero))
        }
        editor.apply()
    }

    fun findById(superHeroId: String): SuperHero? {
        return sharedPref.getString(superHeroId, null)?.let { superHero ->
            gson.fromJson(superHero, SuperHero::class.java)
        }
    }

    fun findAll(): List<SuperHero> {
        val superHeroes = ArrayList<SuperHero>()
        val mapSuperHeroes = sharedPref.all
        mapSuperHeroes.values.forEach {
            superHeroes.add(gson.fromJson(it as String, SuperHero::class.java))
        }
        return superHeroes
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }

    fun deleteById(superHeroId: String) {
        sharedPref.edit().remove(superHeroId).apply()
    }
}