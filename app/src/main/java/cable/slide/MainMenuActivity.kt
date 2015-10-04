package cable.slide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.activity_main_menu.newGame
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.onClick

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        listenForEvents()
    }

    fun listenForEvents() {
        newGame.onClick { startNewGame() }
    }

    fun startNewGame() {
        startActivity(intentFor<GameActivity>())
    }
}