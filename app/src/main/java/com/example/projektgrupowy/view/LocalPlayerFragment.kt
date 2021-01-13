package com.example.projektgrupowy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projektgrupowy.PlayerAdapter
import com.example.projektgrupowy.R
import com.example.projektgrupowy.viewmodel.LocalPlayerAdapter
import com.example.projektgrupowy.viewmodel.LocalPlayerViewModel
import com.example.projektgrupowy.viewmodel.PlayerViewModel
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_local_player.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LocalPlayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocalPlayerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter1: LocalPlayerAdapter
    private lateinit var viewManager1: RecyclerView.LayoutManager
    private lateinit var localPlayerViewModel: LocalPlayerViewModel

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
        localPlayerViewModel= ViewModelProvider(requireActivity()).get(LocalPlayerViewModel::class.java)
        viewManager1= LinearLayoutManager(requireContext())
        adapter1= LocalPlayerAdapter(localPlayerViewModel.players)
        localPlayerViewModel.players.observe(viewLifecycleOwner,{adapter1.notifyDataSetChanged()})


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewLocalPlayer.apply {
            adapter=adapter1
            layoutManager=viewManager1
        }

        buttonBackLocalPlayer.setOnClickListener { view->view.findNavController().navigate(R.id.action_localPlayerFragment_to_welcomeFragment) }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LocalPlayerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocalPlayerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}