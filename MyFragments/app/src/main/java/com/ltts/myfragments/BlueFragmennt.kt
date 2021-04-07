package com.ltts.myfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.blue.view.*

class BlueFragmennt : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        val view = inflater?.inflate(R.layout.blue,container, false)
       /* view.buttonbluee.setOnClickListener {

            var redfrag=RedFragment()
        }
*/


        return view
}


}
