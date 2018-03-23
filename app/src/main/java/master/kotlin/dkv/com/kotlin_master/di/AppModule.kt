package master.kotlin.dkv.com.kotlin_master.di

import android.content.Context
import dagger.Module
import dagger.Provides
import master.kotlin.dkv.com.kotlin_master.app.App
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesContext(application: App): Context = application
}