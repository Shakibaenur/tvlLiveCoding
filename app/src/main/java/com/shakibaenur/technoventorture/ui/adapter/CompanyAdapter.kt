package com.shakibaenur.technoventorture.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shakibaenur.technoventorture.data.model.CompanyDetails
import com.shakibaenur.technoventorture.databinding.ItemCompanyBinding

/**
 * Created by Peal Mazumder on 1/30/2023.
 */

class CompanyAdapter(private var onItemClicked: (item: CompanyDetails) -> Unit) :
    RecyclerView.Adapter<CompanyAdapter.BillPaymentViewHolder>() {
    private val items = arrayListOf<CompanyDetails>()

    fun submitList(data: List<CompanyDetails>) {
        this.items.clear()
        this.items.addAll(data)
        notifyDataSetChanged()
    }
    private fun updateValue(data:CompanyDetails){

        for (item in items){
            if(item.id==data.id){
                item.id=data.id
                item.name=data.name
                item.pk=data.pk
                item.perc=data.perc
            }
        }
        notifyDataSetChanged()

    }


    class BillPaymentViewHolder(val featureItemBinding: ItemCompanyBinding) :
        RecyclerView.ViewHolder(featureItemBinding.root) {

        fun bind(item: CompanyDetails, context: Context) {

            featureItemBinding.tvCpName.text = item.name
            featureItemBinding.tvCpPackage.text = item.pk
            featureItemBinding.tvCpPrice.text = item.price.toString()

            featureItemBinding.tvGP.text = item.pk.toString()
            featureItemBinding.tvGP2.text = item.pk.toString()

            featureItemBinding.tvGPPrice.text = "${item.pk.toString()} $ ${item.pk.toString()}"

            featureItemBinding.tvGPPrice2.text ="${item.pk.toString()} $ ${item.pk.toString()}"

            featureItemBinding.tvGPPercentage.text = item.perc.toString()
            featureItemBinding.tvGPPercentage2.text = item.perc.toString()


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BillPaymentViewHolder {
        val binding = ItemCompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BillPaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BillPaymentViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, holder.itemView.context)

        holder.featureItemBinding.root.setOnClickListener {
            onItemClicked(item)
        }
    }

    override fun getItemCount() = items.size
}