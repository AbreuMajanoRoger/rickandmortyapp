package com.example.rickandmortyapp.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.ResultCharacters
import com.example.rickandmortyapp.databinding.ItemCharacteresBinding
import com.squareup.picasso.Picasso


class CharactersAdapter (private var items: List<ResultCharacters> = listOf(),
                         private val onClickListener: (position:Int) -> Unit
    ) : RecyclerView.Adapter<CharacteresViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacteresViewHolder {
        val binding = ItemCharacteresBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacteresViewHolder(binding)



    }


        override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CharacteresViewHolder, position: Int) {
        holder.render(items[position])
        holder.itemView.setOnClickListener { onClickListener(position) }
    }

    fun updateItems(results: List<ResultCharacters>) {
        items = results
        notifyDataSetChanged()
    }
}

class CharacteresViewHolder(val binding:ItemCharacteresBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(resultcharacters: ResultCharacters) {
        binding.nameTextView.text = resultcharacters.name
        Picasso.get().load(resultcharacters.image).into(binding.photoImageView)
    }

}