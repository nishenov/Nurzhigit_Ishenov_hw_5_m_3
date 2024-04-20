package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCountBinding

class CountFragment : Fragment() {
    private lateinit var binding: FragmentCountBinding
    private var counter = 0
    private var isCountUp = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPlusOne.setOnClickListener {
            if (isCountUp){
                counter++
                binding.tvNumber.text = counter.toString()
                if (counter == 10){
                    isCountUp = false
                    binding.btnPlusOne.text = getText(R.string.minus_one)
                }
            }
            else {
                counter--
                binding.tvNumber.text = counter.toString()
                if (counter == 0){
                    requireActivity().supportFragmentManager.beginTransaction().
                    replace(R.id.container, SecondFragment()).addToBackStack(null)
                        .commit()
                }
            }

        }
    }
}
