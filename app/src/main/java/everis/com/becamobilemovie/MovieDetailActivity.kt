package everis.com.becamobilemovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MovieDetailActivity : AppCompatActivity() {
    private var Movie: Movies? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtra(){
        Movie = intent.getParcelableExtra(EXTRA_FILM)
    }

    companion object{
        const val EXTRA_FILM: String = "EXTRA_FILM"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}