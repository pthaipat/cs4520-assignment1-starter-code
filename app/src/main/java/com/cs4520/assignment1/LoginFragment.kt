package com.cs4520.assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment1.databinding.LoginLayoutBinding

/*
LoginFragment
1. It will have following fields :
    Username : to take input from the user for the username.
    Password : to take input from the user for password.
    Login button.
2. All the views will be in center of screen vertically stacked in order : username, password and
login button
3. Clicking the Login button should navigate to the ProductListFragment, only if the username and
password matches "admin" and "admin" respectively. If the username or password differs, display a toast message. Make sure to clear the fields before navigation.
 */
class LoginFragment : Fragment() {
    private var username: String = ""
    private var password: String = ""
    private var button: Button? = null
    private var _binding: LoginLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginLayoutBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            username = binding.username.text.toString()
            password = binding.password.text.toString()
            login()
        }

        return binding.root
    }

    // login helper function
    private fun login() {
        if (username == "admin" && password == "admin") {
            print("Login successful")
            // navigate to ProductListFragment
            findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
        } else {
            // display a toast message
            val text = "Invalid Login"
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(context, text, duration).show()
        }
    }
}