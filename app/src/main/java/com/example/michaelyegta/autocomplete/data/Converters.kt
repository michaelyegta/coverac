package com.example.michaelyegta.autocomplete.data

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

private const val JSON_FILE_PATH = "carriers.json"
private const val JSON_ARRAY_NAME = "insurance_carriers"

class Converters {
    fun jsonFile2List(context: Context, list: MutableList<String>) {
        val am = context.assets
        var json: String? = null
        try {
            val file = am!!.open(JSON_FILE_PATH)
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        try {
            val obj = JSONObject(json)
            val jsonArray = obj.getJSONArray(JSON_ARRAY_NAME)
            for (i in 0 until jsonArray.length()) list.add(jsonArray.getString(i))
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}