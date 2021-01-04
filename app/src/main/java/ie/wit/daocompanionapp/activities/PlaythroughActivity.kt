package ie.wit.daocompanionapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import ie.wit.daocompanionapp.R
import ie.wit.daocompanionapp.main.MainApp
import ie.wit.daocompanionapp.models.CharacterModel
import ie.wit.daocompanionapp.models.ChoiceModel
import ie.wit.daocompanionapp.models.PlaythroughModel
import ie.wit.daocompanionapp.models.RelationshipModel
import kotlinx.android.synthetic.main.activity_playthrough.*
import kotlinx.android.synthetic.main.activity_playthrough.toolbarAdd
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class PlaythroughActivity : AppCompatActivity(), AnkoLogger {

    var playthrough = PlaythroughModel()
    var character = CharacterModel()
    var choice = ChoiceModel()
    var relationship = RelationshipModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playthrough)
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        info("Playthrough Activity started...")
        app = application as MainApp

        var edit = false
/*
when you click the playthrough card it will allow you to update the user's name for the playthrough.
the add button changes to a save button
 */
        if(intent.hasExtra("playthrough_edit")){
            edit = true
            playthrough = intent.extras?.getParcelable<PlaythroughModel>("playthrough_edit")!!
            playthroughPlayer.setText(playthrough.player)
            btnPlayAdd.setText(R.string.save_playthrough)
        }
/*
When you click on the add character button, switch activities to characterActivity.
 */
        btnCharAdd.setOnClickListener {
           startActivityForResult(intentFor<CharacterActivity>(),0)
        }
/*
when you click on the add choices button, switch activities to choiceActivity.
 */
        btnChoiceAdd.setOnClickListener {
            startActivityForResult(intentFor<ChoiceActivity>(),1)
        }
/*
when you click on the add relationship button, switch activities to relationshipActivity.
 */
        btnRelationshipAdd.setOnClickListener {
            startActivityForResult(intentFor<RelationshipActivity>(),2)
        }
/*
When the add playthrough button is pressed, add the playthrough and go back to the playthroughlist
view
 */
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
/*
when you are creating a playthrough you have the option to cancel. Also when in editing you
can also choose to delete the playthrough
 */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_playthrough, menu)
        return super.onCreateOptionsMenu(menu)
    }
/*
if either cancel or delete is chosen, go back to the playthrough list or delete the selected
playthrough
 */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_delete -> {
                app.playthroughs.delete(playthrough)
                finish()
            }
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
/*
when adding a character/choice/relationship, if they are successful add them to the playthrough
 */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            0 -> {
                character = data?.getParcelableExtra<CharacterModel>("character")!!
                playthrough.characters.add(character)
            }
            1 -> {
                choice = data?.getParcelableExtra<ChoiceModel>("choice")!!
                playthrough.choices.add(choice)
            }
            2 -> {
                relationship = data?.getParcelableExtra<RelationshipModel>("relationship")!!
                playthrough.relationships.add(relationship)
            }
        }
    }
}