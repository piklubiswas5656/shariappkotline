package com.romanticshayarihindi

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.navigation.NavigationView
import com.romanticshayarihindi.Adapter.AdapterQuotes
import com.romanticshayarihindi.Model.QuteModel

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var data: ArrayList<QuteModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();


    }

    fun init() {

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout);
        val navView: NavigationView = findViewById(R.id.navvview);
        toggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> {
                    Toast.makeText(this, "Click Home", Toast.LENGTH_LONG).show()
                }
            }
            true
        }


    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.shareright -> {
                Toast.makeText(this, "Click Home", Toast.LENGTH_LONG).show()
            }
        }
        true
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rightmenu, menu)
        for (i in 0 until menu!!.size()) {
            val menuItem = menu!!.getItem(i)
            val spannable = SpannableString(
                menu!!.getItem(i).title.toString()
            )
            spannable.setSpan(ForegroundColorSpan(Color.YELLOW), 0, spannable.length, 0)
            menuItem.title = spannable
        }
        return super.onCreateOptionsMenu(menu)
    }
}