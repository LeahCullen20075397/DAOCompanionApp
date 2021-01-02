package ie.wit.daocompanionapp.main

import android.app.Application
import ie.wit.daocompanionapp.models.PlaythroughMemStore
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp: Application(), AnkoLogger {

    val playthroughs = PlaythroughMemStore()

    override fun onCreate() {
        super.onCreate()
        info("Playthrough started...")
    }
}