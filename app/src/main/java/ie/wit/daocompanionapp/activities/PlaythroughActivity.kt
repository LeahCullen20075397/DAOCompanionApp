package ie.wit.daocompanionapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.activity_playthrough.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class PlaythroughActivity : AppCompatActivity(), AnkoLogger {

    var playthrough = PlaythroughModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough)
        info("Playthrough Activity started...")

        btnPlayAdd.setOnClickListener {
            playthrough.player = playthroughPlayer.text.toString()
            if(playthrough.player.isNotEmpty()){
                info("Add Playthrough Button pressed: $playthrough")
            }
            else{
                toast("Please enter player name")
            }
        }
    }
}