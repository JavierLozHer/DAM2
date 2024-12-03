package edu.iesam.dam2.app.presentation.views

import android.content.Context
import edu.iesam.dam2.R

interface ErrorAppUI {
    fun getImageError(): Int
    fun getTitleError(): String
    fun getDescriptionError(): String
    fun getActionRetry(): Unit
}

class ServerErrorAppUI(val context: Context): ErrorAppUI {
    override fun getImageError(): Int {
        return R.drawable.ic_launcher_background
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_server)
    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_server)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}

class ConnectionErrorAppUI(val context: Context): ErrorAppUI {
    override fun getImageError(): Int {
        return R.drawable.ic_launcher_background
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_server)
    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_server)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}

class UnknownErrorAppUI(val context: Context): ErrorAppUI {
    override fun getImageError(): Int {
        return R.drawable.ic_launcher_background
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_server)
    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_server)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}