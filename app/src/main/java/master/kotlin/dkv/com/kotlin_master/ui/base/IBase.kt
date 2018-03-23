package master.kotlin.dkv.com.kotlin_master.ui.base

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.View

interface IBase {

    fun setToolBarHolder(view : View)
    fun hideToolBarHolder()
    fun setToolBarHolder(view : View, visibility : Boolean)
    fun setFragment(tag: String, holderId : Int, fragment : Fragment)
    fun initializeToolBar(toolBar : Toolbar? ,title : String)
}