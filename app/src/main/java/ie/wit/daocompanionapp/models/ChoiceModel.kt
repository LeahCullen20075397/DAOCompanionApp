package ie.wit.daocompanionapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChoiceModel (var blight: String = "",
                        var beast: String = "",
                        var paragon: String = "",
                        var orzammar: String = "",
                        var circle: String = "",
                        var landsmeet: String = "",
                        var urn: String = "",
                        var arl: String = "",
                        var archdemon: String = ""): Parcelable