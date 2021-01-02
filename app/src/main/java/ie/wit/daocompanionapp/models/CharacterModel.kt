package ie.wit.daocompanionapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterModel ( var name: String = "",
                            var gender: String = "",
                            var race: String = "",
                            var background: String = "") : Parcelable