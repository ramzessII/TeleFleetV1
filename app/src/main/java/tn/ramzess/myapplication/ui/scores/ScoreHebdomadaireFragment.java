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

public class ScoreHebdomadaireFragment extends Fragment{
    private ScoreViewModel scoreViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.score_hebdomadare_fragment, container, false);
/*        Date dayFirst = TeleFleetUtils.getFirstDayOfWeek(new Date());
        Date dayLast = TeleFleetUtils.getLastDayOfWeek(new Date());
*/
        Date dayFirst = ((MainActivity)getActivity()).getDateDebutScore();
        Date dayLast =  ((MainActivity)getActivity()).getDateFinScore();
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmenthebdomadaire);
        scoreFragment.getScoreViewModel().updateDataWithDate(dayFirst,dayLast);

   /*     scoreViewModel = new ScoreViewModel();
        Date dayFirst = TeleFleetUtils.getFirstDayOfWeek(new Date());
        Date dayLast = TeleFleetUtils.getLastDayOfWeek(new Date());
        scoreViewModel.updateData(Score.SCORE_HEBDOMADAIRE,Score.SCORE_ECO_CONDUIE,dayFirst,dayLast);
        ScoreFragment scoreFragment = (ScoreFragment)getChildFragmentManager().findFragmentById(R.id.fragmenthebdomadaire);
        scoreFragment.initialise(Score.SCORE_HEBDOMADAIRE,root);*/


        return root;
    }
    public void updateDataWithDate(Date dateDeb,Date dateFin)
    {
        scoreViewModel.updateDataWithDate(dateDeb,dateFin);
    }
}
