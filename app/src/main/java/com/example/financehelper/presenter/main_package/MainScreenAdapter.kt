package com.example.financehelper.presenter.main_package

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financehelper.data.model.Finance
import com.example.financehelper.data.model.Money
import com.example.financehelper.data.model.Wallet
import com.example.financehelper.databinding.MoneyAmountBinding
import com.example.financehelper.databinding.WalletItemBinding

class MainScreenAdapter: RecyclerView.Adapter<FinanceViewHolder>() {

    private val list = mutableListOf<Finance>()

    class WalletViewHolder(
        private val binding: WalletItemBinding
    ): FinanceViewHolder(binding.root) {
        override fun bind(finance: Finance) = with(binding) {
            if (finance !is Wallet) return
            walltetName.text = finance.walletName
            moneyLeft.text = finance.moneyLeft.toString()
        }
    }

    class MoneyAmountViewHolder(
        private val binding: MoneyAmountBinding
    ): FinanceViewHolder(binding.root) {
        override fun bind(finance: Finance) = with(binding) {
            if (finance !is Money) return
            salary.text = finance.salary.toString()
            moneySpent.text = finance.moneySpent.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        if (viewType == MONEY_VIEW_TYPE) {
            return MoneyAmountViewHolder(MoneyAmountBinding.inflate(
                inflater,
                parent,
                false
            ))
        } else {
            return WalletViewHolder(WalletItemBinding.inflate(
                inflater,
                parent,
                false
            ))
        }
    }

    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position] is Money) {
            return MONEY_VIEW_TYPE
        } else {
            return WALLET_VIEW_TYPE
        }
    }

    fun submitList(list: List<Finance>) {
        with (this.list) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    companion object {
        private const val WALLET_VIEW_TYPE = 1
        private const val MONEY_VIEW_TYPE = 0
    }
}

abstract class FinanceViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {
    abstract fun bind(finance: Finance)
}