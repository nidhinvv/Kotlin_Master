package master.kotlin.dkv.com.kotlin_master.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import master.kotlin.dkv.com.kotlin_master.ui.login.LoginActivity
import master.kotlin.dkv.com.kotlin_master.ui.main.MainActivity

@Module
abstract class ActivityModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector()
    internal abstract fun contributeSplashActivity(): MainActivity

    @ContributesAndroidInjector()
    internal abstract fun contributeLoginActivity(): LoginActivity


}