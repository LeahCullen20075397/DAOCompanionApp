package ie.wit.daocompanionapp.models

interface PlaythroughStore {

    fun findAll(): List<PlaythroughModel>
    fun create(playthrough: PlaythroughModel)
}