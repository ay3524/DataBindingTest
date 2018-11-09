package com.ay3524.databindingtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ay3524.databindingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val hello: Hello = Hello(
        "Hello Fom Data Binding for 1st text",
        "Hello Fom Data Binding for 2nd text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Using DataBindingUtil to set the content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Initialize the variable name from activity_main.xml with the data class
        binding.hello = hello

        //Now perform the binding operation
        performBindingOperation()
    }

    private fun performBindingOperation() {
        binding.apply {

            //TODO uncomment the below code to show how just altering data in "data class" will effect the change in

            //Changing the text
            hello?.text1 = "Just a test text"

            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
        }
    }
}
