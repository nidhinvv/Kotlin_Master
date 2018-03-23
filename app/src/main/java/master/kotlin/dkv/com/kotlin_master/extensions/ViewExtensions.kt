package master.kotlin.dkv.com.kotlin_master.extensions

import android.support.annotation.LayoutRes
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView

/**
 * ViewGroup extension function to inflate a layout
 *
 * Inflate a view using LayoutInflater
 * examples:
 *      parent.inflate(R.layout.my_layout)
 *      parent.inflate(R.layout.my_layout, true)
 *
 * @param layoutRes Layout resource identifier
 * @param attachToRoot Attach the inflated view to the root, default is false
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

/**
 * Extension function to load an image from a URL
 *
 * Load the image from the specified url and set
 * examples:
 *      imageView.loadUrl("http://....")
 *
 * @param url URL of the image to load
 */
fun ImageView.loadUrl(url: String) {

}

fun EditText.isValidEmail(): Boolean { return Patterns.EMAIL_ADDRESS.matcher(this.text).matches() }
fun EditText.isNullOrEmpty(): Boolean { return this.text.isNullOrEmpty()}