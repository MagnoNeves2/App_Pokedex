package com.github.magnoneves2.apppokedex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AbasAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = ArrayList<Fragment>()
    private val titulosAbas = ArrayList<String>()

    fun add(fragment: Fragment, tituloAba: String){
        fragments.add(fragment)
        titulosAbas.add(tituloAba)
    }

    fun getTitle(position: Int): String {
        return titulosAbas[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

}