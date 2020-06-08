package com.example.navdrawerhomework

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navdrawerhomework.ui.gallery.GalleryFragment
import com.example.navdrawerhomework.ui.home.HomeFragment
import com.example.navdrawerhomework.ui.slideshow.SlideshowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var adapter: RecyclerAdapter
    var itemlist= mutableListOf<MenuModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        init()
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun init(){
        itemlist.add(MenuModel(R.drawable.ic_menu_camera,"Home"))
        itemlist.add(MenuModel(R.drawable.ic_menu_gallery,"Gallery"))
        itemlist.add(MenuModel(R.drawable.ic_menu_slideshow,"Slideshow"))
        adapter= RecyclerAdapter(itemlist,this,object:OnClick{
            override fun click(position: Int) {

                when(itemlist[position].title){
                    "Home"->openFragment(HomeFragment(),"Home")
                    "Gallery"->openFragment(GalleryFragment(),"Gallery")
                    "Slideshow"->openFragment(SlideshowFragment(),"Slideshow")
                }
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager= LinearLayoutManager(this)
    }

    fun openFragment(frag: Fragment, tag:String){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment,frag,tag).commit()
    }

}
