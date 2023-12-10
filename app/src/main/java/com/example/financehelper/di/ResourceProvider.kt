package com.example.financehelper.di

import android.content.Context
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

class ResourceProvider(
    private val context: Context
) {
    init {
        parentContext = context
    }

    fun getString(@StringRes stringId: Int): String = context.getString(stringId)
    fun getString(@StringRes stringId: Int, vararg formatArgs: Any): String =
        context.getString(stringId, *formatArgs)

    fun getColor(colorId: Int) = ContextCompat.getColor(context, colorId)
    fun getDrawable(drawableId: Int) = ContextCompat.getDrawable(context, drawableId)
    fun getDimension(dimenId: Int) = context.resources.getDimension(dimenId)

    companion object {
        private var instance: ResourceProvider? = null
        private lateinit var parentContext: Context

        @Synchronized
        fun instance(): ResourceProvider {
            if (instance == null) instance = ResourceProvider(parentContext)
            return instance as ResourceProvider
        }
    }
}