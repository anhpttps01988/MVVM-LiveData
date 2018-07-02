package com.example.anhptt.firststepmvvm.common.fragment

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

open class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}