package com.abrahamgudratli.myfavoritesofcinema.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.abrahamgudratli.myfavoritesofcinema.R
import com.abrahamgudratli.myfavoritesofcinema.ui.placestogo.PlacesToGoFragment
import com.abrahamgudratli.myfavoritesofcinema.ui.thingstodo.ThingsToDoFragment
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNav.setOnItemSelectedListener(this)

    }

    private fun onThingsClicked() {
//        supportFragmentManager.commit {
//            replace(R.id.fragmentContainerView, ThingsToDoFragment())
//        }
        findNavController(R.id.fragmentContainerView).navigate(R.id.action_placesToGo_to_thingsToDo)
    }

    private fun onPlacesClicked() {
//        supportFragmentManager.commit {
//            replace(R.id.fragmentContainerView, PlacesToGoFragment())
//        }
        findNavController(R.id.fragmentContainerView).navigate(R.id.action_thingsToDo_to_placesToGo)
    }

    override fun onNavigationItemSelected(item: MenuItem) = when(item.itemId) {
            R.id.placesToGo -> {
                onPlacesClicked()
                true
            }
            R.id.thingsToDo -> {
                onThingsClicked()
                true
            }
            else -> false
        }

}