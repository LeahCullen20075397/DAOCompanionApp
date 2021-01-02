package ie.wit.daocompanionapp.main

import android.app.Application
import ie.wit.daocompanionapp.models.PlaythroughModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp: Application(), AnkoLogger {

    val playthroughs = ArrayList<PlaythroughModel>()

    override fun onCreate() {
        super.onCreate()
        info("Playthrough started...")
    }
}