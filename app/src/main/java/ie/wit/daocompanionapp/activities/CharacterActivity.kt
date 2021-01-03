package ie.wit.daocompanionapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.models.CharacterModel
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.activity_playthrough.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class CharacterActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        info("Enter Character Details...")

        var character = CharacterModel()

        btnAddCharacter.setOnClickListener {
            character.name = name.text.toString()
            character.gender = gender.text.toString()
            character.race = race.text.toString()
            character.background = background.text.toString()
            /*
            if (character.name.isNotEmpty() && character.gender.isNotEmpty()
                && character.race.isNotEmpty() && character.background.isNotEmpty()){
                info("$name Added!")
                playthrough.characters.add(character.copy())
                for (i in playthrough.characters.indices){
                    info("Character[$i]: ${playthrough.characters[i]}")
                }
            }
            else{
                toast("Please Enter Character Details...")
            }*/

            setResult(AppCompatActivity.RESULT_OK, Intent().putExtra("character",character))
            finish()
        }
    }
}