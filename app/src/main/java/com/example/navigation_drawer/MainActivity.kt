package com.example.navigation_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle         //This is basically for that hamburger sign that opens our drawer
    lateinit var drawerLayout: DrawerLayout            //To access the drawerLayout outside the onCreate method

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)                                             //This  will provide the Up button in the Appbar to navigates to the parent activity

        navView.setNavigationItemSelectedListener {                                                  //This method is used to set a listener that will be notified when a menu item is selected
            it.isChecked = true                                                                      //It is used to highlight the item that the user tabbed

            when (it.itemId) {
                R.id.nav_profile -> replaceFragment(MyProfileFragment(), it.title.toString())                  //Passing replaceFragment method here to replace the fragment with another
                R.id.nav_services -> replaceFragment(ServicesFragment(),it.title.toString())                   // and also changes the title for the particular fragment selected
                R.id.nav_rateus -> replaceFragment(RateUsFragment(),it.title.toString())
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment,title:String){                     //This method is used to replace the fragments in drawer

        val fragmentManager = supportFragmentManager                                 // reference for fragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()                                               // commit the changes
        drawerLayout.closeDrawers()                                                // close the all open Drawer Views
        setTitle(title)                                                           //To set the title from the arguments that we are getting in this function
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            toggle()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    fun  toggle() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {                              //To check drawer Layout view is visible or not
            drawerLayout.closeDrawer(GravityCompat.START);                                    //To close a drawer
        } else {
            drawerLayout.openDrawer(GravityCompat.START);                                    //To open a drawer
        }
    }
}


