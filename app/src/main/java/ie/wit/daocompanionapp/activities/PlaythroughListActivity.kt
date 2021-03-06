package ie.wit.daocompanionapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.main.MainApp
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.activity_playthrough_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult

class PlaythroughListActivity: AppCompatActivity(), PlaythroughListener {
/*
This class displays the various playthroughs that have been created. It also allows a user to
click on these cards in order to edit those playthroughs
 */
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough_list)
        app = application as MainApp

        toolbar.title = title
        setSupportActionBar(toolbar)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadPlaythroughs()
    }
/*
when a playthrough is clicked, it becomes editable
 */
    override fun onPlaythroughClick(playthrough: PlaythroughModel) {
        startActivityForResult(intentFor<PlaythroughActivity>().putExtra("playthrough_edit",playthrough),0)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
/*
when you click the + button, go to the add playthrough form
 */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_add -> startActivityForResult<PlaythroughActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loadPlaythroughs()
        super.onActivityResult(requestCode, resultCode, data)
    }
/*
load up the previosuly named playthroughs
 */
    private fun loadPlaythroughs(){
        showPlaythroughs(app.playthroughs.findAll())
    }

    fun showPlaythroughs(playthroughs: List<PlaythroughModel>){
        recyclerView.adapter = PlaythroughAdapter(playthroughs, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}