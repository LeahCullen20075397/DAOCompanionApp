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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relationship)

        info("Enter Relationship Details...")

        var relationship = RelationshipModel()

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