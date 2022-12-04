package com.abrahamgudratli.myfavoritesofcinema.ui.placestogo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abrahamgudratli.myfavoritesofcinema.R
import com.abrahamgudratli.myfavoritesofcinema.ui.adapter.PlacesRecyclerviewAdapter
import com.abrahamgudratli.myfavoritesofcinema.viewmodel.ViewModelPlacesToGo
import kotlinx.android.synthetic.main.fragment_places_to_go.view.*

class PlacesToGoFragment : Fragment() {

    lateinit var viewModel: ViewModelPlacesToGo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_places_to_go, container, false)


        val recyclerView = view.recyclerViewPlaces
        val adapter = PlacesRecyclerviewAdapter(this.requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())


        viewModel = ViewModelProvider(this).get(ViewModelPlacesToGo::class.java)
        viewModel.listOfPlaces.observe(viewLifecycleOwner, Observer { places ->
            adapter.setData(places)
        })

        view.fltBtnAddPlace.setOnClickListener {
            findNavController().navigate(R.id.action_placesToGo_to_addPlaceToGo)
        }

        return view
    }

}