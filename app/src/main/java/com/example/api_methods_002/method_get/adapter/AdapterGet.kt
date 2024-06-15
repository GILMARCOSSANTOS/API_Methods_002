package com.example.api_methods_002.method_get.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_methods_002.R
import com.example.api_methods_002.method_get.model.ModelGetItem
import com.google.android.material.textview.MaterialTextView

class AdapterGet(
    private val context: Context,
    private val listUserJson: List<ModelGetItem>
) :
    RecyclerView.Adapter<AdapterGet.UserJsonViewHolder>() {

    class UserJsonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var identification: MaterialTextView? = null
        var name: MaterialTextView? = null
        var phone: MaterialTextView? = null
        var city: MaterialTextView? = null
        var cep: MaterialTextView? = null

        init {

            identification = view.findViewById(R.id.textView_Id_componentGet_id)
            name = view.findViewById(R.id.textView_name_componentGet_id)
            phone = view.findViewById(R.id.textView_phone_componentGet_id)
            city = view.findViewById(R.id.textView_city_componentGet_id)
            cep = view.findViewById(R.id.textView_cep_componentGet_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserJsonViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(
            R.layout.component_get, parent, false
        )

        val holder = UserJsonViewHolder(layoutInflater)
        LayoutInflater.from(parent.context).inflate(R.layout.component_get, parent, false)
        return holder
    }

    override fun onBindViewHolder(holder: UserJsonViewHolder, position: Int) {

        val jsonData = listUserJson[position]
        val city = jsonData.address.city
        println("City = " + city)

        if (jsonData != null) {

            holder.identification?.text = buildString {
                append("▬▬▬ Nº IDENTIFICAÇÃO")
                append(jsonData.id.toString())
                append("▬▬▬")
            }

            holder.name?.text = buildString {
                append("▬▬▬ NOME: ")
                append(jsonData.id.toString())
            }

            holder.phone?.text = buildString {
                append("▬▬▬ TELEFONE: ")
                append(jsonData.id.toString())
            }

            holder.city?.text = buildString {
                append("▬▬▬ CITY: ")
                append(jsonData.id.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return listUserJson.size
    }
}