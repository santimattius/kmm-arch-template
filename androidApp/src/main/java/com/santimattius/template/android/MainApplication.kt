package com.santimattius.template.android

import android.app.Application
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.santimattius.template.android.di.AppConfiguration
import com.santimattius.template.android.ui.theme.AndroidArchTemplateTheme

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppConfiguration.init(app = this)
    }
}

@Composable
fun PicturesApplication(content: @Composable () -> Unit) {
    AndroidArchTemplateTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}