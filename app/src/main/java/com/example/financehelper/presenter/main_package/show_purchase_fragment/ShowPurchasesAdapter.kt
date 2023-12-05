package com.example.financehelper.presenter.main_package.show_purchase_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.financehelper.data.model.Purchase
import com.example.financehelper.databinding.PurchaseItemBinding

class ShowPurchasesAdapter: ListAdapter<Purchase, ShowPurchasesAdapter.PurchaseViewHolder>(PurchaseDiffUtil()) {

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
        val binding = PurchaseItemBinding.inflate(inflater, parent, false)
        return PurchaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PurchaseDiffUtil: DiffUtil.ItemCallback<Purchase>() {
        override fun areItemsTheSame(oldItem: Purchase, newItem: Purchase): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Purchase, newItem: Purchase): Boolean =
            oldItem == newItem

    }
}