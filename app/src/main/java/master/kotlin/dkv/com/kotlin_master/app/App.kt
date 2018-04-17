package master.kotlin.dkv.com.kotlin_master.app

import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import master.kotlin.dkv.com.kotlin_master.di.DaggerAppComponent
import master.kotlin.dkv.com.kotlin_master.util.Pref
import javax.inject.Inject

class App: DaggerApplication(), HasActivityInjector {
    @Inject
    lateinit  var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector;
    }
    override fun onCreate() {
        super.onCreate()
        Pref.init(this, Constant.PREF_NAME)
    }
}