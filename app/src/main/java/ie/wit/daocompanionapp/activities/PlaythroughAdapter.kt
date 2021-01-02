package ie.wit.daocompanionapp.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.card_playthrough.view.*

interface PlaythroughListener{
    fun onPlaythroughClick(playthrough: PlaythroughModel)
}

class PlaythroughAdapter constructor(
    private var playthroughs: List<PlaythroughModel>,
    private val listener: PlaythroughListener
    ) : RecyclerView.Adapter<PlaythroughAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder{
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_playthrough,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val playthrough = playthroughs[holder.adapterPosition]
        holder.bind(playthrough, listener)
    }

    override fun getItemCount(): Int = playthroughs.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(playthrough: PlaythroughModel, listener: PlaythroughListener){
            itemView.playthroughPlayer.text = playthrough.player
            itemView.setOnClickListener { listener.onPlaythroughClick(playthrough) }
        }
    }
}