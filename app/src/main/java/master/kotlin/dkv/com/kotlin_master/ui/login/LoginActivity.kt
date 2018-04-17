package master.kotlin.dkv.com.kotlin_master.ui.login

import android.os.Bundle
import com.jakewharton.rxbinding.view.clicks
import kotlinx.android.synthetic.main.activity_login.*
import master.kotlin.dkv.com.kotlin_master.R
import master.kotlin.dkv.com.kotlin_master.app.Constant
import master.kotlin.dkv.com.kotlin_master.ui.base.BaseActivity
import master.kotlin.dkv.com.kotlin_master.ui.main.MainActivity
import master.kotlin.dkv.com.kotlin_master.util.Pref
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity() {
    private var isLoggedIn by Pref(Constant.PREF_KEY_IS_USER_LOGGED_IN, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.clicks().subscribe{

            isLoggedIn = true
            startActivity<MainActivity>()
        }
    }
}