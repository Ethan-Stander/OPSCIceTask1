package com.example.trumpdumpapi.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.allViews
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.trumpdumpapi.R
import com.example.trumpdumpapi.R.layout.fragment_view_pager
import com.example.trumpdumpapi.onboarding.screen.FirstScreen
import com.example.trumpdumpapi.onboarding.screen.ThirdScreen
import com.example.trumpdumpapi.onboarding.screen.SecondScreen

class ViewPagerFragment : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle


        )
        //view.viewPager=adapter

        return view
    }

}