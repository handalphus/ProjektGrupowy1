package com.example.projektgrupowy.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projektgrupowy.model.dao.PlayerDao
import com.example.projektgrupowy.model.dataModel.PlayerLocal

@Database(
    entities = [PlayerLocal::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase:RoomDatabase(){
    abstract fun playerDao(): PlayerDao

    companion object{
        @Volatile
        private var INSTANCE:LocalDatabase?=null
        fun getDatabase(context: Context):LocalDatabase{
            val tempInstance = INSTANCE

            if(tempInstance!=null)
                return tempInstance
            else
                synchronized(this)
                {
                    val instance= Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "my_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE=instance
                    return instance

                }
        }
    }
}