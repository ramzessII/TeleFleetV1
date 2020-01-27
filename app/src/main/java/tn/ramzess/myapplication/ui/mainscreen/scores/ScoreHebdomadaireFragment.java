package tn.ramzess.myapplication.ui.mainscreen.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

import tn.ramzess.myapplication.R;
import tn.ramzess.myapplication.business.Score;
import tn.ramzess.myapplication.ui.mainscreen.ScoreViewModel;

public class ScoreHebdomadaireFragment extends Fragment{
    private ScoreViewModel scoreViewModel;
    @Override
    public void onResume() {
        super.onResume();
        scoreViewModel = new ScoreViewModel(Score.EST_SCORE_HEBDOMADAIRE);
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreViewModel = new ScoreViewModel(Score.EST_SCORE_HEBDOMADAIRE);
        View root = inflater.inflate(R.layout.score_hebdomadare_fragment, container, false);
        TabLayout tabLayout = root.findViewById(R.id.id_tablayout_annee);
        tabLayout.getTabAt(0).setText("Semaine en cours");
        tabLayout.getTabAt(1).setText("7 derniers jours");
        return root;
    }
}
