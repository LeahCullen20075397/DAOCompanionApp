package ie.wit.daocompanionapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.main.MainApp

class PlaythroughListActivity: AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough_list)
        app = application as MainApp
    }
}