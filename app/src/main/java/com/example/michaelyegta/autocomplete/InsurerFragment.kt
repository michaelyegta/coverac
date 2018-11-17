package com.example.michaelyegta.autocomplete

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import kotlinx.android.synthetic.main.fragment_insurer.*
import com.example.michaelyegta.autocomplete.adapters.AutocompleteAdapter
import com.example.michaelyegta.autocomplete.data.AutocompleteList

/**
 * A simple [Fragment] subclass.
 *
 */
class CarrierFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insurer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set Adapter for AutoCompleteTextView
        val adapter = AutocompleteAdapter(context!!, AutocompleteList().getFromLocal(context!!))
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.threshold = 1

        // clear error reminder for TextInputLayout when selecting a carrier
        autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
            textInputLayout.error = ""
        }

        // basic check if there is non-blank input: end if yes, show on-screen reminder if no
        insurer_next.setOnClickListener {
            val insurer = textInputLayout.editText?.text.toString()

            // checker may be more complicated, such as checking if a valid carrier is in the text
            if (insurer.isBlank()) textInputLayout.error = getString(R.string.error_reminder)
            else {
                val intent = Intent(context, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}
