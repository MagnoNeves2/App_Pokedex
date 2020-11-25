package com.github.magnoneves2.apppokedex.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.magnoneves2.apppokedex.R
import kotlinx.android.synthetic.main.fragment_stats.*

class StatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Ciclo de vida de uma fragment", "onViewCreated")
        txtPrimeiraFragment.text = "Oi!"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Ciclo de vida de uma fragment", "onActivityCreated")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Ciclo de vida de uma fragment", "onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Ciclo de vida de uma fragment", "onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Ciclo de vida de uma fragment", "onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ciclo de vida de uma fragment", "onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Ciclo de vida de uma fragment", "onDestroyView")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ciclo de vida de uma fragment", "onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Ciclo de vida de uma fragment", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Ciclo de vida de uma fragment", "onPause")
    }
}