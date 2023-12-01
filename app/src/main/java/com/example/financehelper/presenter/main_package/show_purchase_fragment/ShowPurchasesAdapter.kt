package com.example.financehelper.presenter.main_package.show_purchase_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.databinding.PurchaseItemBinding

class ShowPurchasesAdapter: RecyclerView.Adapter<ShowPurchasesAdapter.PurchaseViewHolder>() {

    private val list = mutableListOf<Purchase>()

    class PurchaseViewHolder(
        private val binding: PurchaseItemBinding
    ):RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Purchase) = with(binding) {
            purchaseName.text = data.purchaseName
            purchaseCost.text = data.purchaseCost.toString() + "Руб."
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return PurchaseViewHolder(PurchaseItemBinding.inflate(
                inflater,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun submitList(list: List<Purchase>) {
        with (this.list) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }
}