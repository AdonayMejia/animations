package com.example.animations

import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.os.Bundle
import com.example.animations.databinding.FirstAnimationFragmentBinding

class FirstAnimationFragment : Fragment() {
    private lateinit var binding: FirstAnimationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstAnimationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstAnimate.setOnClickListener {
            activity?.apply {
                this.supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.slide_out,
                        R.anim.slide_in,
                        R.anim.slide_out
                    )
                    .replace(R.id.host_fragment, SecondAnimationFragment())
                    .addToBackStack("animation")
                    .commit()
            }
        }
}

}
