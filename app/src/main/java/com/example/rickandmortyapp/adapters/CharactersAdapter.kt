package com.example.rickandmortyapp.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.ResultCharacters
import com.example.rickandmortyapp.databinding.ItemCharacteresBinding
import com.squareup.picasso.Picasso


class CharactersAdapter(
    private var dataSet: List<ResultCharacters> = emptyList(),
    private val onItemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<CharacteresViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacteresViewHolder {
        val binding =
            ItemCharacteresBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacteresViewHolder(binding)


    }


    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CharacteresViewHolder, position: Int) {
        holder.render(dataSet[position])
        holder.itemView.setOnClickListener { onItemClickListener(position) }
    }

    fun updateData(dataSet: List<ResultCharacters>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }
}

class CharacteresViewHolder(val binding: ItemCharacteresBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun render(resultcharacters: ResultCharacters) {
        binding.nameTextView.text = resultcharacters.name
        Picasso.get().load(resultcharacters.image).into(binding.photoImageView)
    }

}