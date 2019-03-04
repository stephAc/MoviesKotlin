package com.example.mymarvel

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.mymarvel.Fragment.AccountFragment
import com.example.mymarvel.Fragment.HomeFragment
import com.example.mymarvel.Fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarHeader.toolbar_title.text="My Marvel"
        handleNavigationClick()
        handleFragmentBody(HomeFragment())
    }

    /*
    Permet de faire des toast partout
    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }*/

    private fun handleNavigationClick() {
        activity_bottom_navigation.setOnNavigationItemSelectedListener { selectedItem ->
            when (selectedItem.itemId) {
                R.id.menu_home ->       handleFragmentBody(HomeFragment())
                R.id.menu_recherche ->  handleFragmentBody(SearchFragment())
                R.id.menu_compte ->     handleFragmentBody(AccountFragment())
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun handleFragmentBody(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.body_fragment, fragment)
        transaction.commit()
    }

}
