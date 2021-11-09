package com.example.animations

import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.os.Bundle
import com.example.animations.databinding.SecondAnimationFragmentBinding
import com.example.animations.databinding.ThirdAnimationFragmentBinding

class SecondAnimationFragment : Fragment() {
    private lateinit var binding: SecondAnimationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondAnimationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.scndFragment.setOnClickListener {
            activity?.apply {
                this.supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.slide_out,
                        R.anim.slide_in,
                        R.anim.slide_out
                    )
                    .replace(R.id.host_fragment, ThirdAnimationFragment())
                    .addToBackStack("animation")
                    .commit()
            }
        }
    }
}