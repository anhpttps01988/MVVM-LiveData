package com.example.anhptt.firststepmvvm.extensions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.replace(fragment: Fragment, containerId: Int) {
    supportFragmentManager.transact { replace(containerId, fragment) }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply { action() }.commit()
}