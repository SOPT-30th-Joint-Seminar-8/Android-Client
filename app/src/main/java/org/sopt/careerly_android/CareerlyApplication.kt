package org.sopt.careerly_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CareerlyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
