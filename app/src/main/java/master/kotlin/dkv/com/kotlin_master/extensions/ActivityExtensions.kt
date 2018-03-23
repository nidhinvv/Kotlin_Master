package master.kotlin.dkv.com.kotlin_master.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import master.kotlin.dkv.com.kotlin_master.app.App



/**
 * Extension function to start an Activity
 *
 * Start and activity
 * examples:
 *      startActivity<ActivityClass>()
 *
 */
inline fun <reified T: Activity> Context.startActivity(){
    val intent = Intent(this, T::class.java)

    startActivity(intent)
}

/**
 * Extension property to get application from Activity
 *
 * Returns application
 * examples:
 *      app
 */
val Activity.app: App
    get() = application as App