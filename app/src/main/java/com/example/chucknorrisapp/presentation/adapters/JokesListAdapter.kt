package com.example.chucknorrisapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.databinding.JokeBinding
import com.example.chucknorrisapp.domain.models.Value

class JokesListAdapter: RecyclerView.Adapter<JokesListAdapter.JokeItemViewHolder>() {

    var list = listOf<Value>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeItemViewHolder {
        val jokeView = JokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeItemViewHolder(jokeView)
    }

    override fun onBindViewHolder(holder: JokeItemViewHolder, position: Int) {
        val value: Value = list[position]
        holder.jokeBinding.apply {
            jokeIdTv.text = "JOKE ID: ${value.id}"
            jokeTextTv.text = value.joke
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class JokeItemViewHolder(val jokeBinding: JokeBinding): RecyclerView.ViewHolder(jokeBinding.root)
}