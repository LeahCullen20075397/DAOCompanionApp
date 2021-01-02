package ie.wit.daocompanionapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.main.MainApp
import ie.wit.daocompanionapp.models.CharacterModel
import ie.wit.daocompanionapp.models.PlaythroughModel
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.activity_playthrough.*
import kotlinx.android.synthetic.main.activity_playthrough.toolbarAdd
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class PlaythroughActivity : AppCompatActivity(), AnkoLogger {

    var playthrough = PlaythroughModel()
    var character = CharacterModel()
    var characters = ArrayList<CharacterModel>()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough)
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        info("Playthrough Activity started...")
        app = application as MainApp

        var edit = false

        if(intent.hasExtra("playthrough_edit")){
            edit = true
            playthrough = intent.extras?.getParcelable<PlaythroughModel>("playthrough_edit")!!
            playthroughPlayer.setText(playthrough.player)
            btnPlayAdd.setText(R.string.save_playthrough)
        }

        btnCharAdd.setOnClickListener {
            info("Enter Character Details...")
            setContentView(R.layout.activity_character)

            btnAddCharacter.setOnClickListener {
                character.name = name.text.toString()
                character.gender = gender.text.toString()
                character.race = race.text.toString()
                character.background = background.text.toString()
                if (character.name.isNotEmpty() && character.gender.isNotEmpty()
                    && character.race.isNotEmpty() && character.background.isNotEmpty()){
                    info("$name Added!")
                    app.characters.add(character.copy())
                    for (i in characters.indices){
                        info("Character[$i]: ${app.characters[i]}")
                    }
                }
                else{
                    toast("Please Enter Character Details...")
                }
            }
        }

        btnPlayAdd.setOnClickListener {
            playthrough.player = playthroughPlayer.text.toString()
            if(playthrough.player.isEmpty()){
                toast(R.string.enter_playthough_player)
            }
            else{
                if(edit){
                    app.playthroughs.update(playthrough.copy())
                }
                else{
                    app.playthroughs.create(playthrough.copy())
                }
            }
            info("Add Button pressed: $playthroughPlayer")
            setResult(AppCompatActivity.RESULT_OK)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_playthrough, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}