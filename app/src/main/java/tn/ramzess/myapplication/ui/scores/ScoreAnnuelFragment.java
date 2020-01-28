package tn.ramzess.myapplication.ui.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Date;

import tn.ramzess.myapplication.MainActivity;
import tn.ramzess.myapplication.R;

public class ScoreAnnuelFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.score_annuel_fragment, container, false);
        inflater.inflate(R.layout.score_mensuel_fragment, container, false);
        inflater.inflate(R.layout.score_hebdomadare_fragment, container, false);
        /*Date dayFirst = TeleFleetUtils.getFirstDayOfYear(new Date());
        Date dayLast = TeleFleetUtils.getLastDayOfYear(new Date());*/
        Date dayFirst = ((MainActivity)getActivity()).getDateDebutScore();
        Date dayLast =  ((MainActivity)getActivity()).getDateFinScore();
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmentannuel);
        scoreFragment.getScoreViewModel().updateDataWithDate(dayFirst,dayLast);
        //scoreViewModel = new ScoreViewModel(root, Score.SCORE_ANNUEL,Score.SCORE_ECO_CONDUIE,dayFirst,dayLast);
/*
        scoreViewModel.updateData(Score.SCORE_ANNUEL,Score.SCORE_ECO_CONDUIE,dayFirst,dayLast);
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmentannuel);
        scoreFragment.initialise(Score.SCORE_ANNUEL,root);*/


        return root;
    }

    public void updateDataWithDate(Date dateDeb,Date dateFin)
    {
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmentannuel);
        scoreFragment.getScoreViewModel().updateDataWithDate(dateDeb,dateFin);
        scoreFragment.getScoreViewModel().updateDataWithDate(dateDeb,dateFin);
    }
}
