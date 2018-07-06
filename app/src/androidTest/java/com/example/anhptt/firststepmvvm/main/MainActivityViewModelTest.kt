package com.example.anhptt.firststepmvvm.main

import android.app.Application
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.runner.AndroidJUnit4
import com.example.anhptt.firststepmvvm.App
import com.example.anhptt.firststepmvvm.DaggerAppComponentForTest
import com.example.anhptt.firststepmvvm.activities.main.viewmodel.MainActivityViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class MainActivityViewModelTest {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var app: Application

    @Before
    fun setUp() {
        app = getInstrumentation().targetContext.applicationContext as App
        val appComponentForTest = DaggerAppComponentForTest.builder()
                .application(app)
                .build()
        appComponentForTest.inject(this)
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testApplication() {
        //force bug test app(Application) not null
        Assert.assertEquals("com.example.anhptt.", app.packageName)
    }

    @Test
    fun testMethodEmpty() {
        Assert.assertEquals(mainActivityViewModel.testDoSomething(),"Dagger UnitTest")
    }

}