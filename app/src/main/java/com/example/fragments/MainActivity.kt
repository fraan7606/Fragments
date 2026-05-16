package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ContactListFragment.OnContactSelectedListener {

    private lateinit var contactInfoFragment: ContactInfoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create fragments programmatically
        val contactListFragment = ContactListFragment()
        contactInfoFragment = ContactInfoFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerInfo, contactInfoFragment)
            .replace(R.id.fragmentContainerList, contactListFragment)
            .commit()
    }

    override fun onContactSelected(contact: Contact) {
        contactInfoFragment.updateContact(contact)
    }
}