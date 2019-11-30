package com.nassdk.supchat.presentation.main.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.nassdk.supchat.R
import com.nassdk.supchat.presentation.main.mvp.MainPresenter
import com.nassdk.supchat.presentation.main.mvp.MainView
import com.nassdk.supchat.domain.model.User
import com.nassdk.supchat.presentation.profilescreen.ui.ProfileActivity
import com.nassdk.supchat.presentation.startscreen.ui.StartActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_header.*

class MainActivity : MvpAppCompatActivity(), MainView, NavigationView.OnNavigationItemSelectedListener {

    //private lateinit var drawerLayout: DrawerLayout

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.fetchData()
        initViews()
    }

    private fun initViews() {

    }


    override fun sendStatus(status: String) = mainPresenter.updateStatus(status)

    override fun openStart() = startActivity(Intent(this, StartActivity::class.java))

    override fun openProfile() = startActivity(Intent(this, ProfileActivity::class.java))


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isCheckable = false

//        when (item.itemId) {
//            R.id.nav_Home -> {
//            }
//            R.id.nav_LogOut -> {
//                mainPresenter.toLogOut()
//            }
//            R.id.nav_Settings -> {
//            }
//            R.id.nav_Profile -> {
//                mainPresenter.toProfile()
//            }
//        }
//        drawerLayout.closeDrawer(GravityCompat.START)
        return false
    }

    override fun onPostResume() {
        super.onPostResume()
        sendStatus("online")
    }

    override fun onPause() {
        super.onPause()
        sendStatus("offline")
    }

    override fun onBackPressed() {

//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            startActivity(Intent(this@MainActivity, StartActivity::class.java))
//            finish()
//        }
    }

    override fun showData(user: User) {

//        navHeader_tvUserName.text = user.userName
//        navHeader_tvEmail.text = user.geteMail()
//
//        if (user.imageURL == "default") {
//            navHeader_ivProfile.setImageResource(R.mipmap.ic_launcher_round)
//        } else {
//            Glide
//                    .with(this@MainActivity)
//                    .load(user.imageURL)
//                    .into(navHeader_ivProfile)
//        }
    }
}