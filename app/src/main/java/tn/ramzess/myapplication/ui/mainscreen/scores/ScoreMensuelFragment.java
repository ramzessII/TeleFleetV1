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

public class ScoreMensuelFragment extends Fragment {
    private ScoreMensuelViewModel scoreMensuelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreMensuelViewModel =
                ViewModelProviders.of(this).get(ScoreMensuelViewModel.class);
        View root = inflater.inflate(R.layout.score_mensuel_fragment, container, false);
        TabLayout tabLayout = root.findViewById(R.id.id_tablayout_annee);
        tabLayout.getTabAt(0).setText("Mois en cours");
        tabLayout.getTabAt(1).setText("30 derniers jours");
        return root;
    }
}
