package com.abrahamgudratli.myfavoritesofcinema.ui.thingstodo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abrahamgudratli.myfavoritesofcinema.R
import com.abrahamgudratli.myfavoritesofcinema.ui.adapter.ThingsRecyclerviewAdapter
import com.abrahamgudratli.myfavoritesofcinema.viewmodel.ViewModelThingsToDo
import kotlinx.android.synthetic.main.fragment_add_thing_to_do.view.*
import kotlinx.android.synthetic.main.fragment_things_to_do.view.*

class ThingsToDoFragment : Fragment() {

    lateinit var viewModel: ViewModelThingsToDo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_things_to_do, container, false)

        val recyclerView = view.recyclerViewThings
        val adapter = ThingsRecyclerviewAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        viewModel = ViewModelProvider(this).get(ViewModelThingsToDo::class.java)
        viewModel.listOfThings.observe(viewLifecycleOwner, Observer { things ->
            adapter.setData(things)
        })

        view.fltBtnAddThing.setOnClickListener {
            findNavController().navigate(R.id.action_thingsToDo_to_addThingToDo)
        }

        return view
    }

}