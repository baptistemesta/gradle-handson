package com.bonitasoft.customext.lib

import com.github.javafaker.Faker

class ClientLib {

    fun getPokemon(): Pokemon {
        val pokemon = Faker().pokemon()
        return Pokemon(pokemon.name(), pokemon.location())
    }
}