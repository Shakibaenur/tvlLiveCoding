package com.shakibaenur.technoventorture.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shakibaenur.technoventorture.data.model.CompanyDetails
import com.shakibaenur.technoventorture.databinding.FragmentHomeBinding
import com.shakibaenur.technoventorture.ui.adapter.CompanyAdapter
import java.util.Random


/**
 * Created by Shakiba E Nur on 22,October,2023
 */
class HomeFragment : Fragment() {

    private lateinit var random: Random
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private var adapter: CompanyAdapter? = null
    var list: List<CompanyDetails> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        adapter = CompanyAdapter(
            this::onItemClick,
        )
        list = mutableListOf(
            CompanyDetails(
                0,
                "GP.PB",
                "Grameen Phone",
                00.00,
                00.00
            ),
        )
        _binding?.rvCompany?.adapter = adapter
        adapter?.submitList(list)

    }

    private fun updateAfterEveryFiveSec() {
        val delay = 5000L
        handler.postDelayed({
            list = mutableListOf(
                CompanyDetails(
                    0,
                    "GP.PB",
                    "Grameen Phone",
                    getRandomFunction(),
                    getRandomFunction(),

                    ),
            )
            adapter?.submitList(list)
        }, delay)
    }

    private fun getRandomFunction(): Double {
        return (random.nextDouble())
    }

    private fun onItemClick(details: CompanyDetails) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
