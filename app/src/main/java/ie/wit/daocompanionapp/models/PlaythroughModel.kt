package ie.wit.daocompanionapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaythroughModel (   var id: Long = 0,
                                var player: String = "",
                                var characters: MutableList<CharacterModel> = mutableListOf(),
                                var choices: MutableList<ChoiceModel> = mutableListOf(),
                                var relationships: MutableList<RelationshipModel> = mutableListOf()) : Parcelable