package com.example.michaelyegta.autocomplete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.findNavController
import com.example.michaelyegta.autocomplete.adapters.PlaceAutocompleteAdapter
import kotlinx.android.synthetic.main.fragment_address.*
import com.google.android.gms.location.places.Places

/**
 * A simple [Fragment] subclass.
 *
 */
class AddressFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Construct a GeoDataClient for the Google Places API for Android.
        // GeoDataClient wraps our service connection to Google Play services and provides access
        // to the Google Places API for Android.
        val geoDataClient = Places.getGeoDataClient(context!!)

        // set Adapter for AutoCompleteTextView
        val adapter = PlaceAutocompleteAdapter(context!!, geoDataClient, null, null)
        autoCompleteTextView.setAdapter<PlaceAutocompleteAdapter>(adapter)
        autoCompleteTextView.threshold = 1

        // clear error reminder for TextInputLayout when selecting a place
        autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
            textInputLayout.error = ""
        }

        // basic check if there is non-blank input: go to next page if yes, show on-screen reminder if no
        address_next.setOnClickListener {
            val address = textInputLayout.editText?.text.toString()

            // checker may be more complicated, such as checking if a valid place/address is in the text
            if (address.isBlank()) textInputLayout.error = getString(R.string.error_reminder)
            else view.findNavController().navigate(R.id.action_addressFragment_to_carrierFragment)
        }
    }
}
