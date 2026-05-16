package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactAdapter
    private var onContactSelectedListener: OnContactSelectedListener? = null

    interface OnContactSelectedListener {
        fun onContactSelected(contact: Contact)
    }

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        if (context is OnContactSelectedListener) {
            onContactSelectedListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        val contacts = generateContacts()
        adapter = ContactAdapter(contacts) { contact ->
            onContactSelectedListener?.onContactSelected(contact)
        }
        recyclerView.adapter = adapter
    }

    private fun generateContacts(): List<Contact> {
        return listOf(
            Contact(1, "Contacto 1", "Apellido 1", "111111111", "C/Calle 1"),
            Contact(2, "Contacto 2", "Apellido 2", "222222222", "C/Calle 2"),
            Contact(3, "Contacto 3", "Apellido 3", "333333333", "C/Calle 3"),
            Contact(4, "Contacto 4", "Apellido 4", "444444444", "C/Calle 4"),
            Contact(5, "Contacto 5", "Apellido 5", "555555555", "C/Calle 5"),
            Contact(6, "Contacto 6", "Apellido 6", "666666666", "C/Calle 6"),
            Contact(7, "Contacto 7", "Apellido 7", "777777777", "C/Calle 7"),
            Contact(8, "Contacto 8", "Apellido 8", "888888888", "C/Calle 8")
        )
    }

    override fun onDetach() {
        super.onDetach()
        onContactSelectedListener = null
    }
}
