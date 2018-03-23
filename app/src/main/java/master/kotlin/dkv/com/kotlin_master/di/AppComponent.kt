package master.kotlin.dkv.com.kotlin_master.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import master.kotlin.dkv.com.kotlin_master.app.App
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (ActivityModule::class),
    (FragmentModule::class),
    (ViewModelModule::class)
])
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}