package cable.slide.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cable.slide.R
import org.jetbrains.anko.toast

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        toast("Starting new game. Have fun!")
    }
}
