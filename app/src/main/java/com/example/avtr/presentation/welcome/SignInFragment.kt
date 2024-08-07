package com.example.avtr.presentation.welcome

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.avtr.R
import com.example.avtr.databinding.FragmentSignInBinding
import com.example.avtr.domain.entity.UserModel
import com.example.avtr.presentation.AsosiyActivity
import com.example.avtr.presentation.ViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel by lazy { ViewModelProvider(this)[ViewModel::class.java] }
    private val pasList = ArrayList<Int>()

    private lateinit var binding: FragmentSignInBinding
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
            FragmentSignInBinding.inflate(LayoutInflater.from(inflater.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reg = viewModel.registered()

        if (reg) {
            oldUser()
        } else {
            newUser()
        }
        viewModel.psLiveData.observe(viewLifecycleOwner){
            if(it.size > 3){
                val passwordUserTest = viewModel.passwordUserTest()
                val oneData = passwordUserTest / 1000 //2 345
                val twoDatax = passwordUserTest % 1000
                val twoData=twoDatax/ 100 // 3 45
                val threeDataX=twoDatax % 100
                val threeData = threeDataX / 10 // 4 5
                val fourData = twoData % 10 // 4 5
                Log.d("MY_TAG", "testMsOldUser: "+""+oneData+" "+twoData+" "+threeData+" "+fourData)

                if (oneData==it.get(0) && twoData==it.get(1) && threeData==it.get(2) && fourData==it.get(3)){
                    //new oynaga
                   val intent=Intent(requireActivity(),AsosiyActivity::class.java)
                    startActivity(intent)
                }else{
                    //clear password
                    Log.d("MY_TAG", "testMsOldUser: ${pasList.toList()} ${viewModel.getUserPasswordUsecase()}")
                    pasList.clear()
                    binding.cardOne.setCardBackgroundColor(Color.WHITE)
                    binding.cardTwo.setCardBackgroundColor(Color.WHITE)
                    binding.cardThree.setCardBackgroundColor(Color.WHITE)
                    binding.cardFour.setCardBackgroundColor(Color.WHITE)
                }

            }
        }
    }

    @SuppressLint("ResourceType")
    private fun newUser() {
        binding.infoTxtId.text = "Parol O`rnating"
        val animationText = AnimationUtils.loadAnimation(requireActivity(), R.drawable.anim_text)
        binding.infoTxtId.visibility = View.VISIBLE
        binding.infoTxtId.animation = animationText

        binding.numOne.setOnClickListener {
            testMsNewUser(1)
        }
        binding.numTwo.setOnClickListener {
            testMsNewUser(2)
        }
        binding.numThree.setOnClickListener {
            testMsNewUser(3)
        }
        binding.numFour.setOnClickListener {
            testMsNewUser(4)
        }
        binding.numFive.setOnClickListener {
            testMsNewUser(5)
        }
        binding.numSix.setOnClickListener {
            testMsNewUser(6)
        }
        binding.numSevn.setOnClickListener {
            testMsNewUser(7)
        }
        binding.numEight.setOnClickListener {
            testMsNewUser(8)
        }
        binding.numNi.setOnClickListener {
            testMsNewUser(9)
        }
        binding.numZero.setOnClickListener {
            testMsNewUser(0)
        }

    }

    private fun testMsNewUser(i:Int) {
        if(pasList.size<=4){
            var son=""
            for (i in pasList){
                son=son+i
            }
            viewModel.addUser(UserModel(password = son.toInt(), userId = 1))
        }else if(pasList.size==4){
            pasList.add(i)

            when(pasList.size){
                1->binding.cardOne.setCardBackgroundColor(Color.YELLOW)
                2->binding.cardOne.setCardBackgroundColor(Color.YELLOW)
                3->binding.cardOne.setCardBackgroundColor(Color.YELLOW)
                4->binding.cardOne.setCardBackgroundColor(Color.YELLOW)
            }
            Toast.makeText(requireActivity(), "$i qushildi listga", Toast.LENGTH_SHORT).show()
        }else{
            pasList.clear()
            binding.cardOne.setCardBackgroundColor(Color.WHITE)
            binding.cardTwo.setCardBackgroundColor(Color.WHITE)
            binding.cardThree.setCardBackgroundColor(Color.WHITE)
            binding.cardFour.setCardBackgroundColor(Color.WHITE)
        }
    }

    private fun testMsOldUser(i:Int) {


           if(pasList.size<4){
           pasList.add(i)
               viewModel.addListPassword(pasList)
           when(pasList.size){
               1->binding.cardOne.setCardBackgroundColor(Color.YELLOW)
               2->binding.cardTwo.setCardBackgroundColor(Color.YELLOW)
               3->binding.cardThree.setCardBackgroundColor(Color.YELLOW)
               4->binding.cardFour.setCardBackgroundColor(Color.YELLOW)
           }
           Toast.makeText(requireActivity(), "$i Bosildi listga", Toast.LENGTH_SHORT).show()
       }else{
               if(viewModel.passwordUserTest() > 0){
                   val passwordUserTest = viewModel.passwordUserTest()
                   val oneData = passwordUserTest / 1000 //2 345
                   val twoDatax = passwordUserTest % 1000
                   val twoData=twoDatax/ 100 // 3 45
                   val threeDataX=twoDatax % 100
                   val threeData = threeDataX / 10 // 4 5
                   val fourData = twoData % 10 // 4 5
                   Log.d("MY_TAG", "testMsOldUser: "+""+oneData+" "+twoData+" "+threeData+" "+fourData)

                   if (oneData==pasList.get(0) && twoData==pasList.get(1) && threeData==pasList.get(2) && fourData==pasList.get(3)){
                       //new oynaga
                       Toast.makeText(requireActivity(), "Login", Toast.LENGTH_SHORT).show()
                   }else{
                       //clear password
                       Log.d("MY_TAG", "testMsOldUser: ${pasList.toList()} ${viewModel.getUserPasswordUsecase()}")
                       pasList.clear()
                       binding.cardOne.setCardBackgroundColor(Color.WHITE)
                       binding.cardTwo.setCardBackgroundColor(Color.WHITE)
                       binding.cardThree.setCardBackgroundColor(Color.WHITE)
                       binding.cardFour.setCardBackgroundColor(Color.WHITE)
                   }

               }else{
                   //clear password
                   Log.d("MY_TAG", "testMsOldUser: ${pasList.toList()} ${viewModel.getUserPasswordUsecase()}")
                   pasList.clear()
                   binding.cardOne.setCardBackgroundColor(Color.WHITE)
                   binding.cardTwo.setCardBackgroundColor(Color.WHITE)
                   binding.cardThree.setCardBackgroundColor(Color.WHITE)
                   binding.cardFour.setCardBackgroundColor(Color.WHITE)

               }
           }
    }


    @SuppressLint("ResourceType")
    private fun oldUser() {


        binding.infoTxtId.text = "Parol kiriting"
        val animationText = AnimationUtils.loadAnimation(requireActivity(), R.drawable.anim_text)
        binding.infoTxtId.visibility = View.VISIBLE
        binding.infoTxtId.animation = animationText

        binding.numOne.setOnClickListener {
            testMsOldUser(1)
        }
        binding.numTwo.setOnClickListener {
            testMsOldUser(2)
        }
        binding.numThree.setOnClickListener {
            testMsOldUser(3)
        }
        binding.numFour.setOnClickListener {
            testMsOldUser(4)
        }
        binding.numFive.setOnClickListener {
            testMsOldUser(5)
        }
        binding.numSix.setOnClickListener {
            testMsOldUser(6)
        }
        binding.numSevn.setOnClickListener {
            testMsOldUser(7)
        }
        binding.numEight.setOnClickListener {
            testMsOldUser(8)
        }
        binding.numNi.setOnClickListener {
            testMsOldUser(9)
        }
        binding.numZero.setOnClickListener {
            testMsOldUser(0)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}