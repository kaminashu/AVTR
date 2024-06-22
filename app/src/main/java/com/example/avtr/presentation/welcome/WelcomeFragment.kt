package com.example.avtr.presentation.welcome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.avtr.R
import com.example.avtr.REGISTER
import com.example.avtr.databinding.FragmentWelcomeBinding
import com.example.avtr.presentation.ViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel by lazy { ViewModelProvider(this)[ViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentWelcomeBinding.inflate(LayoutInflater.from(inflater.context), container, false)
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animation = AnimationUtils.loadAnimation(requireActivity(), R.drawable.anim_text)
        val animation2 = AnimationUtils.loadAnimation(requireActivity(), R.drawable.roate)
        binding.textView.visibility = View.VISIBLE
        binding.textView.animation = animation
        binding.nextBtn.visibility = View.VISIBLE
        binding.nextBtn.animation = animation
        binding.textView2.visibility = View.VISIBLE
        binding.textView2.animation = animation2
        binding.nextBtn.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_infoFragment,)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}