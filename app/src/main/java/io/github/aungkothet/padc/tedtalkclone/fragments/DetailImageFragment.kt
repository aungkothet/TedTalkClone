package io.github.aungkothet.padc.tedtalkclone.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.aungkothet.padc.tedtalkclone.R
import kotlinx.android.synthetic.main.fragment_detail_image.view.*

class DetailImageFragment : Fragment() {

    private val ARG_POSITION = "position"

    companion object {
        fun newInstance(position: Int): DetailImageFragment {
            return DetailImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_POSITION, position)
                }
            }
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_image, container, false)
        val position = arguments?.getInt(ARG_POSITION) ?: 0
        val images =
                arrayListOf(R.drawable.talk1, R.drawable.talk2, R.drawable.talk3, R.drawable.talk4, R.drawable.talk5)
        view.detailImageView.setImageResource(images[position])
        return view
    }


}
