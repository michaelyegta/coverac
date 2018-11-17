package com.example.michaelyegta.autocomplete.adapters

import android.content.Context
import android.widget.ArrayAdapter

class AutocompleteAdapter (context: Context, list: List<String>)
    : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list)