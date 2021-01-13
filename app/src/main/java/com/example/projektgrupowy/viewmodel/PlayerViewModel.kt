package com.example.projektgrupowy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projektgrupowy.model.Player

class PlayerViewModel(application: Application): AndroidViewModel(application) {

    private var _players: MutableLiveData<List<Player>> = MutableLiveData()
    val players: LiveData<List<Player>>
    get() {
        val playerzy= listOf<Player>(Player(5345,"ja",3,2,5,2,5,2,5),
            Player(6756,"2ja",3,2,5,2,5,2,5),
            Player(2363,"3ja",3,2,5,2,5,2,5),
            Player(7542,"4ja",3,2,5,2,5,2,5))
        _players.value=playerzy
        return _players
    }

}