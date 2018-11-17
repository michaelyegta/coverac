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
import com.google.android.gms.location.places.GeoDataClient
import com.google.android.gms.location.places.Places
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

/**
 * A simple [Fragment] subclass.
 *
 */
class AddressFragment : Fragment() {
    // GeoDataClient wraps our service connection to Google Play services and provides access
    // to the Google Places API for Android.
    private lateinit var mGeoDataClient: GeoDataClient

    // Place Autocomplete Adapter
    private lateinit var mAdapter: PlaceAutocompleteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Construct a GeoDataClient for the Google Places API for Android.
        mGeoDataClient = Places.getGeoDataClient(context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        address_next.setOnClickListener {
            val address = textInputLayout.editText?.text.toString()
            if (address.isBlank()) textInputLayout.error = getString(R.string.error_reminder)
            else view.findNavController().navigate(R.id.action_addressFragment_to_carrierFragment)
        }

        autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
            textInputLayout.error = ""
        }
        mAdapter = PlaceAutocompleteAdapter(context!!, mGeoDataClient, null, null)
        autoCompleteTextView.setAdapter<PlaceAutocompleteAdapter>(mAdapter)
        autoCompleteTextView.threshold = 1
    }

    companion object {
        private const val TAG = "AddressFragment"
    }
}
