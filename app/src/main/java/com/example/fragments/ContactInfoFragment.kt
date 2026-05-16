package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ContactInfoFragment : Fragment() {

    private lateinit var tvNombre: TextView
    private lateinit var tvApellidos: TextView
    private lateinit var tvTelefono: TextView
    private lateinit var tvDireccion: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        tvNombre = view.findViewById(R.id.tvNombre)
        tvApellidos = view.findViewById(R.id.tvApellidos)
        tvTelefono = view.findViewById(R.id.tvTelefono)
        tvDireccion = view.findViewById(R.id.tvDireccion)
    }

    fun updateContact(contact: Contact) {
        tvNombre.text = "Nombre: ${contact.nombre}"
        tvApellidos.text = "Apellidos: ${contact.apellidos}"
        tvTelefono.text = "Teléfono: ${contact.telefono}"
        tvDireccion.text = "Dirección: ${contact.direccion}"
    }
}
