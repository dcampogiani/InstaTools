package com.danielecampogiani.instatools.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.danielecampogiani.instatools.R
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val aboutPage = AboutPage(this)
            .setDescription(getString(R.string.app_name))
            .isRTL(false)
            .setImage(R.mipmap.ic_launcher)
            .addEmail("daniele.campogiani.dev@gmail.com")
            .addItem(getHowToUse())
            .addWebsite("http://danielecampogiani.com/InstaToolsSite/")
            .addInstagram("dcampogiani")
            .create()

        setContentView(aboutPage)
    }

    private fun getHowToUse(): Element {
        return Element().apply {
            title = getString(R.string.how_to_use)
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CwRJSkysxoM"))
            iconDrawable = R.drawable.ic_slideshow_black_24dp
        }
    }
}
