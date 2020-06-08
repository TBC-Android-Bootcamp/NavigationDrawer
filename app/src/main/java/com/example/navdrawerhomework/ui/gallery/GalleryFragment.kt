package com.example.navdrawerhomework.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.navdrawerhomework.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        //val textView: TextView = root.findViewById(R.id.text_gallery)
        //galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        //})
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }
}
