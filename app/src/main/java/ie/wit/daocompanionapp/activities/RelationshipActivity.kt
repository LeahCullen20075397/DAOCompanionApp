package ie.wit.daocompanionapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.models.ChoiceModel
import ie.wit.daocompanionapp.models.RelationshipModel
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_relationship.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class RelationshipActivity: AppCompatActivity(), AnkoLogger {
    /*
        When the add relationships button on the add playthrough is pressed the view changes to the
        activity_relationship layout. This layout contains a form to fill out based on the relationships
        you want to make during your playthrough.
         */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relationship)

        info("Enter Relationship Details...")

        var relationship = RelationshipModel()
/*
When the user is finished filling out the form, they will hit the Add Relationships button. This will pass
what they entered into the relationshipModel class. it will also send a result_ok response to the playthroughActivity
class. This tells the app to add those choices to the playthrough. A message will also display on
logcat to state the add was successful. Once that has occurred, it goes back to the add playthrough
view.
 */
        btnAddRelationship.setOnClickListener {
            relationship.alastair = alastair.text.toString()
            relationship.leliana = leliana.text.toString()
            relationship.morrigan = morrigan.text.toString()
            relationship.oghren = oghren.text.toString()
            relationship.shale = shale.text.toString()
            relationship.sten = sten.text.toString()
            relationship.wynne = wynne.text.toString()
            relationship.zevran = zevran.text.toString()

            setResult(AppCompatActivity.RESULT_OK, Intent().putExtra("relationship",relationship))
            info("Relationship added!")
            finish()
        }
    }
}