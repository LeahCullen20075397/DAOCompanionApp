package ie.wit.daocompanionapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.main.MainApp
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.activity_playthrough.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class PlaythroughActivity : AppCompatActivity(), AnkoLogger {

    var playthrough = PlaythroughModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough)
        info("Playthrough Activity started...")
        app = application as MainApp

        btnPlayAdd.setOnClickListener {
            playthrough.player = playthroughPlayer.text.toString()
            if(playthrough.player.isNotEmpty()){
                app.playthroughs.add(playthrough.copy())
                info("Add Playthrough Button pressed: ${playthrough}")
                for (i in app.playthroughs.indices){
                    info("Playthrough[$i]:${app.playthroughs[i]}")
                }
            }
            else{
                toast("Please enter player name")
            }
        }
    }
}