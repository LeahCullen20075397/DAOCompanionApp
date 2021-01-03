package ie.wit.daocompanionapp.main

import android.app.Application
import ie.wit.daocompanionapp.models.CharacterModel
import ie.wit.daocompanionapp.models.PlaythroughMemStore
import ie.wit.daocompanionapp.models.PlaythroughStore
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp: Application(), AnkoLogger {

    lateinit var playthroughs: PlaythroughStore

    override fun onCreate() {
        super.onCreate()
        playthroughs = PlaythroughMemStore()
        info("Playthrough started...")
    }
}