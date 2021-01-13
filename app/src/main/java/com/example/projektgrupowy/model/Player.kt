package com.example.projektgrupowy.model

data class Player(
    val id: Long,
    val playerName: String,
    val numberOfRabbit: Int,
    val numberOfSheep: Int,
    val numberOfPig: Int,
    val numberOfCow: Int,
    val numberOfHorse: Int,
    val numberOfDog: Int,
    val numberOfBigDog: Int
)