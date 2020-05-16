package com.bhanupro.swiflearnui.ui.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhanupro.swiflearnui.MainActivity

import com.bhanupro.swiflearnui.R
import com.bhanupro.swiflearnui.ui.adapter.PastClassesAdapter
import kotlinx.android.synthetic.main.fragment_appbar.*
import kotlinx.android.synthetic.main.fragment_past_classes.*

/**
 * A simple [Fragment] subclass.
 */
class PastClassesFragment : Fragment() {

    private lateinit var adapter: PastClassesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, Callback())
    }
    inner class Callback : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            activity?.finish()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        setPastClassesRv()
        clickListeners()
    }
    private fun setToolbar(){
        (activity as MainActivity).setSupportActionBar(toolbar)
    }

    private fun setPastClassesRv() {
        pastClassesRv?.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
        adapter = PastClassesAdapter(getPastClasses())
        pastClassesRv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun clickListeners() {
        subjectCv?.setOnClickListener {
            showSubjectsPopUp()
        }
    }

    private fun getPastClasses(): ArrayList<String> {

        val list = ArrayList<String>()
        for (i in 0..15) {
            list.add("Past Classes $i")
        }
        return list
    }

    private fun showSubjectsPopUp() {
        val popup = PopupWindow(requireContext())
        val layout = LayoutInflater.from(requireContext())
            .inflate(R.layout.subject_menu_layout, subjectCv, false)

        popup.apply {
            contentView = layout
            setBackgroundDrawable(ColorDrawable(Color.WHITE))
            isFocusable = true
            elevation = 4.0f
        }
        popup.showAsDropDown(subjectCv)

        popup.setOnDismissListener {
            Log.d("PastClasses","setOnDismissListener")
        }

    }

}
