package ie.wit.daocompanionapp.activities

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.main.MainApp
import kotlinx.android.synthetic.main.activity_playthrough_list.*
import org.jetbrains.anko.startActivityForResult

class PlaythroughListActivity: AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough_list)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PlaythroughAdapter(app.playthroughs.findAll())

        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_add -> startActivityForResult<PlaythroughActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }
}