package com.example.michaelyegta.autocomplete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_address.*
import com.google.android.gms.location.places.Place
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class AddressFragment : Fragment() {
    private var placeSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_address, container, false)

        placeSelected = false
        val autocompleteFragment = SupportPlaceAutocompleteFragment()
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place?) {
                if (place != null) {
                    placeSelected = true
                    textInputLayout.error = ""
                }
            }

            override fun onError(status: Status) {
                // TODO: Handle the error.
            }
        })
        fragmentManager?.beginTransaction()?.replace(R.id.fragment_content, autocompleteFragment)?.commit()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        address_next.setOnClickListener {
            if (placeSelected)
                view.findNavController().navigate(R.id.action_addressFragment_to_carrierFragment)
            else textInputLayout.error = getString(R.string.error_reminder)
        }
    }
}
