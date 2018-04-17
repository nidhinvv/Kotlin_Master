package master.kotlin.dkv.com.kotlin_master.ui.splash

import android.os.Bundle
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import master.kotlin.dkv.com.kotlin_master.R
import master.kotlin.dkv.com.kotlin_master.app.Constant
import master.kotlin.dkv.com.kotlin_master.extensions.startActivity
import master.kotlin.dkv.com.kotlin_master.log.Logger
import master.kotlin.dkv.com.kotlin_master.log.info
import master.kotlin.dkv.com.kotlin_master.ui.base.BaseActivity
import master.kotlin.dkv.com.kotlin_master.ui.login.LoginActivity
import master.kotlin.dkv.com.kotlin_master.ui.main.MainActivity
import master.kotlin.dkv.com.kotlin_master.util.Pref


class SplashActivity : BaseActivity(), Logger {

    private val delayTime: Long = 3000
    private var delayJob: Job? = null
    private var isLoggedIn by Pref(Constant.PREF_KEY_IS_USER_LOGGED_IN, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Navigate with delay
        delayJob = delaySplashScreen()

        info("Exiting from onCreate")
    }

    public override fun onDestroy() {
        delayJob?.cancel()


        super.onDestroy()
    }

    private fun delaySplashScreen() = launch(UI) {
        info("Start waiting...")
        async(CommonPool) { delay(delayTime) }.await()
        info("End waiting...")

        info("Starting Login Activity...")
        if (isLoggedIn) {
            startActivity<MainActivity>()
        } else {
            startActivity<LoginActivity>()
        }

        finish()
    }
}