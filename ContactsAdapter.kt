package com.example.apiarchitecture.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.apiarchitecture.R
import com.example.apiarchitecture.model.Contacts

class ContactsAdapter(private val result: List<Contacts>, private val mContext: Context) :
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ContactsAdapter.ContactsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_contacts, null)
        return ContactsViewHolder(v)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: ContactsViewHolder, pos: Int) {
        val contacts : Contacts =result.get(pos)
        holder.bind(contacts)
    }

    class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id: TextView
        var name: TextView
        var email: TextView
        var gender: TextView
        var mobile: TextView

        init {
            id = itemView.findViewById(R.id.ids)
            name = itemView.findViewById(R.id.name)
            email = itemView.findViewById(R.id.email)
            gender = itemView.findViewById(R.id.gender)
            mobile = itemView.findViewById(R.id.mobile)
        }

        fun bind(contacts: Contacts) {
            id.text = contacts.id
            name.text = contacts.name
            email.text = contacts.email
            gender.text = contacts.gender
            mobile.text = contacts.phone.mobile
        }
    }
}
