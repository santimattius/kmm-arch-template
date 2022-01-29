package com.santimattius.template.android.di

import android.app.Application
import com.santimattius.template.cache.DatabaseDriverFactory
import com.santimattius.template.di.initModule
import org.koin.core.context.loadKoinModules

class AppConfiguration {

    companion object {

        fun init(app: Application) {
            initModule(DatabaseDriverFactory(app)){
                loadKoinModules(modules)
            }
        }
    }
}