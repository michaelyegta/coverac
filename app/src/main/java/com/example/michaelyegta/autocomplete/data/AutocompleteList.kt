package com.example.michaelyegta.autocomplete.data

import android.content.Context

class AutocompleteList {
    fun getFromLocal(context: Context): List<String> {
        val list = ArrayList<String>()
        Converters().jsonFile2List(context, list)
        return list
    }
}