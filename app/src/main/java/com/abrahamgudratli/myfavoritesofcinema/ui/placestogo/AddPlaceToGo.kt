package com.abrahamgudratli.myfavoritesofcinema.ui.placestogo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.abrahamgudratli.myfavoritesofcinema.R
import com.abrahamgudratli.myfavoritesofcinema.data.PlacesToGo
import com.abrahamgudratli.myfavoritesofcinema.viewmodel.ViewModelPlacesToGo
import kotlinx.android.synthetic.main.fragment_add_place_to_go.*
import kotlinx.android.synthetic.main.fragment_add_place_to_go.view.*


class AddPlaceToGo : Fragment() {

    lateinit var viewModel: ViewModelPlacesToGo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_add_place_to_go, container, false)

        viewModel = ViewModelProvider(this).get(ViewModelPlacesToGo::class.java)

        view.btnAddPlace.setOnClickListener {
            addPlaceToDatabase()
        }



        return view
    }

    private fun addPlaceToDatabase() {
        val title = etvTitlePlace.text.toString()
        val description = etvDescriptionPlace.text.toString()
        val rate = etvRatePlace.text.toString()
        val image = etvLinkPlace.text.toString()

        val place = PlacesToGo(0, title, description, image, rate)
        viewModel.add(place)

        findNavController().navigate(R.id.action_addPlaceToGo_to_placesToGo)
    }

}