package com.example.api_methods_002.method_post.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_methods_002.R
import com.example.api_methods_002.method_post.model.SigninPostModelBody
import com.example.api_methods_002.method_post.model.SigninPostModelResponse
import com.google.android.material.textview.MaterialTextView

class SigninAdapter(private val dataList: ArrayList<SigninPostModelBody>) :
    RecyclerView.Adapter<SigninAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sign, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        // Configurar ViewHolder com os dados do item
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(newData: List<SigninPostModelBody>) {
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged() // Notificar o RecyclerView que os dados foram atualizados
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: SigninPostModelBody) {
            // Aqui você configura os dados para exibição no item da RecyclerView
            itemView.findViewById<MaterialTextView>(R.id.textViewIdentificacao).text = item.identificationNumber.toString()
            itemView.findViewById<MaterialTextView>(R.id.textViewCpf).text = item.cpf.toString()
            itemView.findViewById<MaterialTextView>(R.id.textViewNome).text = item.name
            itemView.findViewById<MaterialTextView>(R.id.textViewEmail).text = item.email
            itemView.findViewById<MaterialTextView>(R.id.textViewCidade).text = item.city
        }
    }
}

