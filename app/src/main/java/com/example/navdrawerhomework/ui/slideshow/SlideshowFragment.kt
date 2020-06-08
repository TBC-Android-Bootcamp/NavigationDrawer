package com.example.navdrawerhomework.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.navdrawerhomework.R

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        //val textView: TextView = root.findViewById(R.id.text_slideshow)
        //slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
       // })
        return inflater.inflate(R.layout.fragment_slideshow, container, false)
    }
}
