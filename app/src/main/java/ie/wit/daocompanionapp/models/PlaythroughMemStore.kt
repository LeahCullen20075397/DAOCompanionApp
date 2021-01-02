package ie.wit.daocompanionapp.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class PlaythroughMemStore : PlaythroughStore, AnkoLogger {

    val playthroughs = ArrayList<PlaythroughModel>()

    override fun findAll(): List<PlaythroughModel> {
        return playthroughs
    }

    override fun create(playthrough: PlaythroughModel) {
        playthroughs.add(playthrough)
        logAll()
    }

    fun logAll(){
        playthroughs.forEach { info("${it}") }
    }
}