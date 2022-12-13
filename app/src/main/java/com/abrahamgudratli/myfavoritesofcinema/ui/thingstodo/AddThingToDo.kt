package com.abrahamgudratli.myfavoritesofcinema.ui.thingstodo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.abrahamgudratli.myfavoritesofcinema.R
import com.abrahamgudratli.myfavoritesofcinema.data.ThingsToDo
import com.abrahamgudratli.myfavoritesofcinema.viewmodel.ViewModelThingsToDo
import kotlinx.android.synthetic.main.fragment_add_thing_to_do.*
import kotlinx.android.synthetic.main.fragment_add_thing_to_do.view.*

class AddThingToDo : Fragment() {

    lateinit var viewModel: ViewModelThingsToDo
    lateinit var urri: Uri
    lateinit var uri: String
    lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_add_thing_to_do, container, false)

        viewModel = ViewModelProvider(this).get(ViewModelThingsToDo::class.java)

        view.ivPictureThing.setOnClickListener {
            selectImage()
        }

        view.btnAddThing.setOnClickListener {
            addThingToDatabase()
        }

        return view
    }

    private fun selectImage() {
        intent = Intent(Intent.ACTION_GET_CONTENT).also {
            it.addCategory(Intent.CATEGORY_OPENABLE)
            it.type = "image/*"
            it.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
            it.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            it.action = Intent.ACTION_GET_CONTENT
        }
        if (intent.resolveActivity(activity?.packageManager!!) != null) {
            startActivityForResult(intent, 0)
        }
    }

    private fun addThingToDatabase() {
        val title: String = etvTitleThing.text.toString()
        val description = etvDescriptionThing.text.toString()
        val rate = etvRateThing.text.toString()
        val imageUri = uri

        val thing = ThingsToDo(0, title, description, imageUri, rate)
        viewModel.add(thing)

        findNavController().navigate(R.id.action_addThingToDo_to_thingsToDo)
    }

    @SuppressLint("WrongConstant")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 0 && resultCode == Activity.RESULT_OK) {
            uri = data?.data.toString()
        }

    }



}