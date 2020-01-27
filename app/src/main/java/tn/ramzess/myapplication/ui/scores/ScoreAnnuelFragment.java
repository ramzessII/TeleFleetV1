package tn.ramzess.myapplication.ui.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import tn.ramzess.myapplication.R;
import tn.ramzess.myapplication.business.Score;

public class ScoreAnnuelFragment extends Fragment {
    private ScoreViewModel scoreViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreViewModel = new ScoreViewModel();
        scoreViewModel.updateData(Score.SCORE_ANNUEL,Score.SCORE_ECO_CONDUIE);
        View root = inflater.inflate(R.layout.score_annuel_fragment, container, false);
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmentannuel);
        scoreFragment.initialise(Score.SCORE_ANNUEL,root);
        return root;
    }
}
