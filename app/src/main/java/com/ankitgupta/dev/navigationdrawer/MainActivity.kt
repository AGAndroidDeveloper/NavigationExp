package com.ankitgupta.dev.navigationdrawer


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.animation.core.Animation
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ankitgupta.dev.navigationdrawer.databinding.ActivityMainBinding
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


// bottom navigation clicking on bottom nav change fragment accordingly
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var toolbar: Toolbar? = null
    private var navController: NavController? = null
    private var btmNavView: BottomNavigationView? = null
    var host: NavHostFragment? = null
    var appBarConfig: AppBarConfiguration? = null
    var navView :NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        toolbar = binding?.toolbar
        setSupportActionBar(toolbar)
        toolbar!!.setNavigationOnClickListener {
            binding?.drawerLayout?.openDrawer(GravityCompat.START)
        }

        host =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment?
        navController = host!!.findNavController()
        appBarConfig = AppBarConfiguration(setOf(R.id.profile, R.id.reward, R.id.home))


        //setupActionBarWithNavController(navController!!,binding?.drawerLayout)
        toolbar!!.setupWithNavController(navController!!, binding?.drawerLayout)
        setupBottomNavMenu(navController!!)

        navView = binding?.navigationView


         clickListener()

        changeDestination(navView!!)

//        navController!!.addOnDestinationChangedListener { _, destination, _ ->
//            if(destination.id == R.id.full_screen_destination) {
//                toolbar.visibility = View.GONE
//                bottomNavigationView.visibility = View.GONE
//            } else {
//                toolbar.visibility = View.VISIBLE
//                bottomNavigationView.visibility = View.VISIBLE
//            }
//        }

    }

    private fun   changeDestination(nav:NavigationView) {
        nav.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item clicks here
            when (menuItem.itemId) {

                R.id.send -> {
                    navController!!.navigate(R.id.action_home_to_send2)
                    binding?.drawerLayout?.closeDrawer(GravityCompat.START)

                }

                R.id.likes_Image -> {
                    navController!!.navigate(R.id.action_home_to_blankFragment)
                    binding?.drawerLayout?.closeDrawer(GravityCompat.START)

                }

                else -> {}
            }



            true
        }
    }


    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navView)
        bottomNav?.setupWithNavController(navController)
    }

  private  fun clickListener(){
        navView!!.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
           // drawerLayout.close()
            true
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val nav = host!!.findNavController()

        when (item.itemId) {
            R.id.setting -> {
                    nav.navigate(R.id.setting)
            }
            R.id.send ->{
               findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_home_to_send2)
            }
        }

        return super.onOptionsItemSelected(item)

    }


    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()
    }
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment_container).navigateUp()
    }






}