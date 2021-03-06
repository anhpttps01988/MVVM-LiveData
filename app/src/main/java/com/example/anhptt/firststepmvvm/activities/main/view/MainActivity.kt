package com.example.anhptt.firststepmvvm.activities.main.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.anhptt.firststepmvvm.R
import com.example.anhptt.firststepmvvm.common.viewmodel.ViewModelFactory
import com.example.anhptt.firststepmvvm.activities.detail.view.DetailActivity
import com.example.anhptt.firststepmvvm.activities.main.adapter.BookAdapter
import com.example.anhptt.firststepmvvm.activities.main.viewmodel.MainActivityContract
import com.example.anhptt.firststepmvvm.activities.main.viewmodel.MainActivityViewModel
import com.example.anhptt.firststepmvvm.common.activity.BaseActivity
import com.example.anhptt.firststepmvvm.common.di.scopes.PerActivity
import com.example.anhptt.firststepmvvm.databinding.ActivityMainBinding
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject
import javax.inject.Qualifier

@PerActivity
class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, MainActivityContract.Navigator {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: BookAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        viewModel = ViewModelProviders.of(this@MainActivity, viewModelFactory).get(MainActivityViewModel::class.java)
        lifecycle.addObserver(viewModel)
        //set viewmodel load data
        binding.appBarMain!!.contentMain!!.viewModel = viewModel
        //set viewmodel navigator event
        binding.appBarMain!!.viewModel = viewModel
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        viewModel.goToDetail.observe(this, Observer {
            this.goToDetail()
        })
        mAdapter = BookAdapter(listOf())
        recyclerView.addItemDecoration(DividerItemDecoration(this, 1))
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, 1, false)
        recyclerView.adapter = mAdapter
    }

    override fun goToDetail() {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
