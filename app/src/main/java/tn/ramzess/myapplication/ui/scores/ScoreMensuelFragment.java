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

public class ScoreMensuelFragment extends Fragment {
    private ScoreViewModel scoreViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.score_mensuel_fragment, container, false);
 /*       Date dayFirst = TeleFleetUtils.getFirstDayOfMonth(new Date());
        Date dayLast = TeleFleetUtils.getLastDayOfMonth(new Date());
*/
        Date dayFirst = ((MainActivity)getActivity()).getDateDebutScoreMensuel();
        Date dayLast =  ((MainActivity)getActivity()).getDateFinScoreMensuel();
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmentmensuel);
        scoreFragment.getScoreViewModel().updateDataWithDate(dayFirst,dayLast);
/*
        scoreViewModel.updateData(Score.SCORE_MENSUEL,Score.SCORE_ECO_CONDUIE,dayFirst,dayLast);
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmentmensuel);
        scoreFragment.initialise(Score.SCORE_MENSUEL,root);*/


        return root;
    }

    public void updateDataWithDate(Date dateDeb,Date dateFin)
    {
        scoreViewModel.updateDataWithDate(dateDeb,dateFin);
    }
}
