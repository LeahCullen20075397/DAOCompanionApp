package ie.wit.daocompanionapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.models.ChoiceModel
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.activity_choice.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class ChoiceActivity: AppCompatActivity(), AnkoLogger {
    /*
    When the add choices button on the add playthrough is pressed the view changes to the activity_choice
    layout. This layout contains a form to fill out based on the choices you want to make
    during your playthrough.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        info("Enter Choice Details...")

        var choice = ChoiceModel()
/*
When the user is finished filling out the form, they will hit the Add Choices button. This will pass
what they entered into the choiceModel class. it will also send a result_ok response to the playthroughActivity
class. This tells the app to add those choices to the playthrough. A message will also display on
logcat to state the add was successful. Once that has occurred, it goes back to the add playthrough
view.
 */
        btnAddChoice.setOnClickListener {
            choice.blight = blight.text.toString()
            choice.beast = beast.text.toString()
            choice.paragon = beast.text.toString()
            choice.orzammar = orzammar.text.toString()
            choice.circle = circle.text.toString()
            choice.landsmeet = landsmeet.text.toString()
            choice.urn = urn.text.toString()
            choice.arl = arl.text.toString()
            choice.archdemon = archdemon.text.toString()

            setResult(AppCompatActivity.RESULT_OK, Intent().putExtra("choice",choice))
            info("Choices were added!")
            finish()
        }
    }
}