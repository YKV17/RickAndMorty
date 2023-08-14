package com.noble.home_presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.noble.common_utils.adapters.image_loading.ImageLoadingAdapter
import com.noble.common_utils.base.BaseAdapter
import com.noble.home_domain.models.Character
import com.noble.home_presentation.databinding.ItemCharacterListBinding
import javax.inject.Inject

class CharactersAdapter @Inject constructor(private val imageLoadingAdapter: ImageLoadingAdapter) :
    BaseAdapter<Character>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }


    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCharacterListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val viewHolder = CharacterViewHolder(binding)

        viewHolder.itemView.setOnClickListener {
            onItemClickListener?.let { itemClick ->
                itemClick(list[viewHolder.adapterPosition])
            }
        }

        return viewHolder
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterListBinding) :
        ViewHolder(binding.root), Binder<Character> {
        override fun bind(item: Character) {
            binding.apply {
                tvCharacterName.text = item.name
                tvLocation.text = item.characterLocation.name
                tvStatus.text = "${item.status} - ${item.species}"
                imageLoadingAdapter.loadImage(item.image, ivCharacter)
            }
        }

    }

}