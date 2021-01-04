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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        info("Enter Choice Details...")

        var choice = ChoiceModel()

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