package com.danielecampogiani.instatools

import android.app.Application
import android.content.Context
import com.danielecampogiani.instatools.inject.AppComponent
import com.danielecampogiani.instatools.inject.AppModule
import com.danielecampogiani.instatools.inject.DaggerAppComponent

class InstaToolsApplication : Application() {

    companion object {
        fun getAppComponent(context: Context): AppComponent {
            val app = context.applicationContext as InstaToolsApplication
            return app.appComponent
        }
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}