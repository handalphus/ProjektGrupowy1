package com.example.projektgrupowy.model.dataModel

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "player_table")
data class PlayerLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val numberOfRabbit: Int,
    val numberOfSheep: Int,
    val numberOfPig: Int,
    val numberOfCow: Int,
    val numberOfHorse: Int,
    val numberOfDog: Int,
    val numberOfBigDog: Int

)