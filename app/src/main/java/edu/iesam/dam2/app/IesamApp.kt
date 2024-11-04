package edu.iesam.dam2.app

import android.app.Application
import edu.iesam.dam2.app.di.AppModule
import org.koin.core.context.startKoin

class IesamApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
        //    androidContext(this@IesamApp)
        //    modules(AppModule().module)
        }
    }

}