package ie.wit.daocompanionapp.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class PlaythroughMemStore : PlaythroughStore, AnkoLogger {

    val playthroughs = ArrayList<PlaythroughModel>()

    override fun findAll(): List<PlaythroughModel> {
        return playthroughs
    }

    override fun create(playthrough: PlaythroughModel) {
        playthrough.id = getId()
        playthroughs.add(playthrough)
        logAll()
    }

    override fun update(playthrough: PlaythroughModel) {
        var foundPlaythrough: PlaythroughModel? = playthroughs.find { p -> p.id == playthrough.id }
        if (foundPlaythrough != null){
            foundPlaythrough.player = playthrough.player
            logAll()
        }
    }

    override fun delete(playthrough: PlaythroughModel) {
        playthroughs.remove(playthrough)
    }

    fun logAll(){
        playthroughs.forEach { info("${it}") }
    }
}