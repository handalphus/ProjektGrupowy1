package com.example.projektgrupowy.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.projektgrupowy.PlayerAdapter
import com.example.projektgrupowy.R
import com.example.projektgrupowy.model.Player
import com.example.projektgrupowy.model.dataModel.PlayerLocal

class LocalPlayerAdapter(var data: LiveData<List<PlayerLocal>>): RecyclerView.Adapter<LocalPlayerAdapter.NoteHolder>() {

    class NoteHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view= LayoutInflater.from(parent.context).
        inflate(R.layout.one_row_local_player,parent,false) as View
        return NoteHolder(view)
    }

    override fun getItemCount(): Int {
        return data.value?.size?:0
    }

    override fun onBindViewHolder(holder: LocalPlayerAdapter.NoteHolder, position: Int) {

        val textViewKroliki=holder.itemView.findViewById<TextView>(R.id.textViewKroliki)
        val textViewOwce=holder.itemView.findViewById<TextView>(R.id.textViewOwce)
        val textViewSwinie=holder.itemView.findViewById<TextView>(R.id.textViewSwinie)
        val textViewKrowy=holder.itemView.findViewById<TextView>(R.id.textViewKrowy)
        val textViewKonie=holder.itemView.findViewById<TextView>(R.id.textViewKonie)
        val textViewPsyMale=holder.itemView.findViewById<TextView>(R.id.textViewPsyMale)
        val textViewPsyDuze=holder.itemView.findViewById<TextView>(R.id.textViewPsyDuze)

        textViewKroliki.text=data.value?.get(position)?.numberOfRabbit?.toString()?:""
        textViewOwce.text=data.value?.get(position)?.numberOfSheep?.toString()?:""
        textViewSwinie.text=data.value?.get(position)?.numberOfPig?.toString()?:""
        textViewKrowy.text=data.value?.get(position)?.numberOfCow?.toString()?:""
        textViewKonie.text=data.value?.get(position)?.numberOfHorse?.toString()?:""
        textViewPsyMale.text=data.value?.get(position)?.numberOfDog?.toString()?:""
        textViewPsyDuze.text=data.value?.get(position)?.numberOfBigDog?.toString()?:""
    }


}