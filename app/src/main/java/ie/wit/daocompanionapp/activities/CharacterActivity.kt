package ie.wit.daocompanionapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.models.CharacterModel
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.activity_playthrough.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class CharacterActivity : AppCompatActivity(), AnkoLogger {
/*
When the add character button on the add playthrough is pressed. Change over to the activity_character
layout. This layout contains a form to fill out based on the character you want to play as
during your playthrough.
 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        info("Enter Character Details...")

        var character = CharacterModel()

/*
When the user is finished filling out the form, they will hit the Add Character button. This will pass
what they entered into the characterModel class. it will also send a result_ok response to the playthroughActivity
class. This tells the app to add that character to the playthrough. A message will also display on
logcat to state the add was successful. Once that has occurred, it goes back to the add playthrough
view.
 */
        btnAddCharacter.setOnClickListener {
            character.name = name.text.toString()
            character.gender = gender.text.toString()
            character.race = race.text.toString()
            character.background = background.text.toString()

            setResult(AppCompatActivity.RESULT_OK, Intent().putExtra("character",character))
            info("${character.name} added!")
            finish()
        }
    }
}

