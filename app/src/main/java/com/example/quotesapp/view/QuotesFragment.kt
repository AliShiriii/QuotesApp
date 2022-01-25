package com.example.quotesapp.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.quotesapp.adapter.QuotesAdapter
import com.example.quotesapp.databinding.FragmentQuotesBinding
import com.example.quotesapp.interfase.CopyListener
import com.example.quotesapp.viewModel.QuotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuotesFragment : Fragment() {

    private lateinit var _binding: FragmentQuotesBinding
    private val binding get() = _binding

    private lateinit var quotesAdapter: QuotesAdapter
    private val viewModel: QuotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuotesBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUbRecyclerView()
        getAllQuotesData()

    }

    private fun setUbRecyclerView() {

        quotesAdapter = QuotesAdapter(copyListener)

        binding.apply {

            quotesRecyclerView.setHasFixedSize(true)
            quotesRecyclerView.adapter = quotesAdapter

        }

    }

    private fun getAllQuotesData() {

        viewModel.callQuotes()
        viewModel.quotes.observe(viewLifecycleOwner, Observer { response ->

            quotesAdapter.differ.submitList(response)

        })
    }

    private val copyListener: CopyListener = object : CopyListener{
        override fun onCopiedClick(text: String) {

//            val clipBoard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
//            val clip = ClipData.newPlainText("clipboard_data", text)
//
//            clipBoard.setPrimaryClip(clip)

            Toast.makeText(requireContext(), "text copied on board", Toast.LENGTH_LONG).show()
        }

    }
}