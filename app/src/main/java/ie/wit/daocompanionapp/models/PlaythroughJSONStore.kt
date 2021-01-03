package ie.wit.daocompanionapp.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import ie.wit.daocompanionapp.helpers.exists
import ie.wit.daocompanionapp.helpers.read
import ie.wit.daocompanionapp.helpers.write
import org.jetbrains.anko.AnkoLogger
import java.util.*
import kotlin.collections.ArrayList

val JSON_FILE = "playthroughs.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<PlaythroughModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class PlaythroughJSONStore : PlaythroughStore, AnkoLogger {

    val context: Context
    var playthroughs = mutableListOf<PlaythroughModel>()

    constructor(context: Context){
        this.context = context
        if(exists(context, JSON_FILE)){
            deserialize()
        }
    }

    override fun findAll(): MutableList<PlaythroughModel> {
        return playthroughs
    }

    override fun create(playthrough: PlaythroughModel) {
        playthrough.id = generateRandomId()
        playthroughs.add(playthrough)
        serialize()
    }

    override fun update(playthrough: PlaythroughModel) {
        val playthroughList = findAll() as ArrayList<PlaythroughModel>
        var foundPlaythrough: PlaythroughModel? = playthroughList.find { p -> p.id == playthrough.id }
        if (foundPlaythrough != null){
            foundPlaythrough.player = playthrough.player
        }
        serialize()
    }

    override fun delete(playthrough: PlaythroughModel) {
        playthroughs.remove(playthrough)
        serialize()
    }

    private fun serialize(){
        val jsonString = gsonBuilder.toJson(playthroughs, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize(){
        val jsonString = read(context, JSON_FILE)
        playthroughs = Gson().fromJson(jsonString, listType)
    }
}