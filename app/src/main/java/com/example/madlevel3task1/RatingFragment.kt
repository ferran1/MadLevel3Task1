package com.example.madlevel3task1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_rating.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RatingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //navigate to summary fragment when the button is clicked
        btn_to_summary.setOnClickListener {
            navigateToSummary()
        }

        showRandomAssessableGame()
    }

    private fun navigateToSummary() {

        val args = Bundle()
        args.putFloat(ARG_GAME_RATING, ratingBar_game.rating)
        args.putString(ARG_GAME_NAME, txt_game.text.toString())

        // navigate to the next (summary fragment) and pass the data (game rating and game name) in a bundle within the parameters
        findNavController().navigate(R.id.action_ratingFragment_to_summaryFragment, args)
    }


    // Show random game name in the txt_game textview
    private fun showRandomAssessableGame() {
        val randomGame = listOf(
            "Red Dead Redemption 2", "Rocket League",
            "Shadow of the Tombraider"
        ).random()

        txt_game.text = randomGame
    }
}