package ie.wit.daocompanionapp.main

import android.app.Application
import ie.wit.daocompanionapp.models.CharacterModel
import ie.wit.daocompanionapp.models.PlaythroughJSONStore
import ie.wit.daocompanionapp.models.PlaythroughMemStore
import ie.wit.daocompanionapp.models.PlaythroughStore
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp: Application(), AnkoLogger {

    lateinit var playthroughs: PlaythroughStore
/*
on start-up pull playthroughs from the jsonfile
 */
    override fun onCreate() {
        super.onCreate()
        playthroughs = PlaythroughJSONStore(applicationContext)
        info("Playthrough started...")
    }
}