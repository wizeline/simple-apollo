package com.wizeline.simpleapollosample

import android.app.Application
import com.wizeline.simpleapollo.SimpleApollo
import com.wizeline.simpleapollosample.data.dataModule
import com.wizeline.simpleapollosample.main.mainModule
import com.wizeline.simpleapollosample.post.postModule
import com.wizeline.simpleapollosample.usecases.useCasesModule
import com.wizeline.simpleapollosample.utils.simpleApolloSampleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SimpleApolloSample : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeSimpleApolloClient(this)
        initializeDependencyInjection(this)
    }

    private fun initializeSimpleApolloClient(application: Application) {
        SimpleApollo.initialize(application)
    }

    private fun initializeDependencyInjection(application: Application) {
        startKoin {
            androidContext(application)
            androidLogger()
            androidFileProperties()
            modules(
                listOf(
                    simpleApolloSampleModule,
                    dataModule,
                    useCasesModule,
                    mainModule,
                    postModule
                )
            )
        }
    }
}
