package master.kotlin.dkv.com.kotlin_master.ui.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View


open class BaseActivity : AppCompatActivity(), IBase, FragmentManager.OnBackStackChangedListener {
    private val BACK_STACK_COUNT: Int = 1
    private var toolBarHolder: View? = null

    override fun hideToolBarHolder() {
        toolBarHolder?.visibility = View.GONE
    }

    override fun setToolBarHolder(view: View) {

        this.toolBarHolder = view
    }

    override fun setToolBarHolder(view: View, visibility: Boolean) {

        this.toolBarHolder = view
        val state: Int = if (visibility) View.VISIBLE else View.GONE
        toolBarHolder?.visibility = state
    }

    override fun setFragment(tag: String, holderId: Int, fragment: Fragment) {

        supportFragmentManager.beginTransaction().add(holderId, fragment, tag).commit()
    }

    override fun initializeToolBar(toolBar: Toolbar?, title: String) {

        toolBar?.setTitle("")
        setSupportActionBar(toolBar)
        supportActionBar?.setTitle(title)
    }

    override fun onBackStackChanged() {

        supportActionBar?.setHomeButtonEnabled(supportFragmentManager.backStackEntryCount > BACK_STACK_COUNT)
    }

    override fun onBackPressed() {

        manageBack()
    }

    override fun onSupportNavigateUp(): Boolean {

        manageBack()
        return true
    }

    protected fun registerBackStackListener() {
        supportFragmentManager.addOnBackStackChangedListener { this }
    }

    private fun manageBack() {

        if (supportFragmentManager.backStackEntryCount > BACK_STACK_COUNT) {

            supportFragmentManager?.popBackStack()

        } else {

            finish()
        }
    }
}