package com.example.projektgrupowy.model.repo

import com.example.projektgrupowy.model.dao.PlayerDao
import com.example.projektgrupowy.model.dataModel.PlayerLocal

class PlayerLocalRepository(private val playerDao: PlayerDao) {

    suspend fun addPlayerLocal( numberOfRabbit: Int,
                                numberOfSheep: Int,
                                numberOfPig: Int,
                                numberOfCow: Int,
                                numberOfHorse: Int,
                                numberOfDog: Int,
                                numberOfBigDog: Int){
        playerDao.insert(PlayerLocal(0,numberOfRabbit,numberOfSheep,numberOfPig,numberOfCow,numberOfHorse,numberOfDog,numberOfBigDog))
    }

}