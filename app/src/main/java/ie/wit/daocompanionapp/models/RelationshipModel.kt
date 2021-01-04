package ie.wit.daocompanionapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelationshipModel (  var alastair: String = "",
                                var leliana: String = "",
                                var morrigan: String = "",
                                var oghren: String = "",
                                var shale: String = "",
                                var sten: String = "",
                                var wynne: String = "",
                                var zevran: String = ""): Parcelable