package com.example.projektgrupowy.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projektgrupowy.model.Player
import com.example.projektgrupowy.model.dataModel.PlayerLocal

@Dao
interface PlayerDao {
    @Insert
    suspend fun insert(player: PlayerLocal)

    @Query("select * from player_table")
    fun allItems():LiveData<List<PlayerLocal>>
}