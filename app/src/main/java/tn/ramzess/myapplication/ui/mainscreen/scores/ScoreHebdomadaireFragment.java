package tn.ramzess.myapplication.ui.mainscreen.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.tabs.TabLayout;

import tn.ramzess.myapplication.R;

public class ScoreHebdomadaireFragment extends Fragment{
    private ScoreHebdomadaireViewModel scoreHebdomadaireViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreHebdomadaireViewModel =
                ViewModelProviders.of(this).get(ScoreHebdomadaireViewModel.class);
        View root = inflater.inflate(R.layout.score_hebdomadare_fragment, container, false);
        TabLayout tabLayout = root.findViewById(R.id.id_tablayout_annee);
        tabLayout.getTabAt(0).setText("Semaine en cours");
        tabLayout.getTabAt(1).setText("7 derniers jours");
        return root;
    }
}
