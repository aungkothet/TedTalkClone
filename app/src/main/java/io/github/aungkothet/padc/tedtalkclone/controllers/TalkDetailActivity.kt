package io.github.aungkothet.padc.tedtalkclone.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import io.github.aungkothet.padc.tedtalkclone.R
import io.github.aungkothet.padc.tedtalkclone.adapters.ImagePagerAdapter
import io.github.aungkothet.padc.tedtalkclone.utilities.IE_DURATION
import io.github.aungkothet.padc.tedtalkclone.utilities.IE_SPEAKER_NAME
import io.github.aungkothet.padc.tedtalkclone.utilities.IE_TALK_TITLE
import kotlinx.android.synthetic.main.activity_talk_detail.*
import kotlinx.android.synthetic.main.content_talk_detail.*

class TalkDetailActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context,speakerName: String, duration: String, talkTitle: String): Intent{
            return Intent(context, TalkDetailActivity::class.java).apply {
                putExtra(IE_SPEAKER_NAME,speakerName)
                putExtra(IE_DURATION,duration)
                putExtra(IE_TALK_TITLE,talkTitle)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk_detail)
        setSupportActionBar(detail_toolbar)
        val imagePagerAdapter = ImagePagerAdapter(supportFragmentManager)
        imageViewPager.adapter = imagePagerAdapter
        fab.setOnClickListener { view ->
            val snackBar = Snackbar.make(view, "Action Play will start soon.", Snackbar.LENGTH_INDEFINITE)
                    snackBar.setAction("Okay") {
                        snackBar.dismiss()
                    }.show()
        }
        tv_duration_detail.text = intent.getStringExtra(IE_DURATION)
        tv_speaker_name_detail.text = intent.getStringExtra(IE_SPEAKER_NAME)
        tv_talk_title_detail.text = intent.getStringExtra(IE_TALK_TITLE)
        tb_playlist.setOnClickListener { view->
            var playlistSnackMsg =  if(tb_playlist.isChecked){
                "Added to My List."
            }else {
                "Removed from My List."
            }
            val snackBar = Snackbar.make(view,playlistSnackMsg,Snackbar.LENGTH_LONG)
            snackBar.setAction("UNDO"){
                tb_playlist.isChecked = !tb_playlist.isChecked
            }.show()

        }
        tb_fav.setOnClickListener { view->
            if(tb_fav.isChecked){
                Snackbar.make(view,"Added to Likes.",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
