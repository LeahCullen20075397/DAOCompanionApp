package ie.wit.daocompanionapp.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.main.MainApp
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.card_playthrough.view.*
import kotlinx.android.synthetic.main.activity_playthrough_list.*

class PlaythroughListActivity: AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough_list)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PlaythroughAdapter(app.playthroughs)

        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

}

class PlaythroughAdapter constructor(private var playthroughs: List<PlaythroughModel>) :
        RecyclerView.Adapter<PlaythroughAdapter.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder{
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_playthrough,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int){
        val playthrough = playthroughs[holder.adapterPosition]
        holder.bind(playthrough)
    }

    override fun getItemCount(): Int = playthroughs.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(playthrough: PlaythroughModel){
            itemView.playthroughPlayer.text = playthrough.player
        }
    }
}