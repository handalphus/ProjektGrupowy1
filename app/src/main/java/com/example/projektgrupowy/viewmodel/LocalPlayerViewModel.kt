package com.example.projektgrupowy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projektgrupowy.model.LocalDatabase
import com.example.projektgrupowy.model.Player
import com.example.projektgrupowy.model.dataModel.PlayerLocal
import com.example.projektgrupowy.model.repo.PlayerLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalPlayerViewModel(application: Application): AndroidViewModel(application) {

    private val playerLocalRepository:PlayerLocalRepository =
        PlayerLocalRepository(LocalDatabase.getDatabase(application).playerDao())

    lateinit var _players: LiveData<List<PlayerLocal>>



    val players: LiveData<List<PlayerLocal>> = LocalDatabase.getDatabase(application).playerDao().allItems()
    init {

       GlobalScope.launch {
           playerLocalRepository.addPlayerLocal(3,2,5,2,5,2,5)

       }
    }
}