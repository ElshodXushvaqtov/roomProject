package com.example.myapplication.util

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Database.AppDataBase
import com.example.myapplication.Entity.User
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val appDataBase: AppDataBase by lazy {
        AppDataBase.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.toReg.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, RegistrationFragment()).commit()
        }
        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_studentPageFragment)
        }

        binding.login.setOnClickListener {
            var login = binding.name.text.toString()
            var password = binding.pass.text.toString()
            var user: User
            if (login != "" && password != "") {
                user = appDataBase.getUsersDao().getUser(login, password)
                if (user.role.toLowerCase().equals("student")) {
                    findNavController().navigate(R.id.action_loginFragment_to_studentPageFragment)
                }

                if (user.role.toLowerCase().equals("teacher")) {
                    findNavController().navigate(R.id.action_loginFragment_to_teacherPageFragment)
                }
            }

        }
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}