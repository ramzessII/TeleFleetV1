package tn.ramzess.myapplication.ui.mainscreen.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import tn.ramzess.myapplication.R;

public class ScoreAnnuelFragment extends Fragment {
    private ScoreAnnuelViewModel scoreAnnuelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreAnnuelViewModel =
                ViewModelProviders.of(this).get(ScoreAnnuelViewModel.class);
        View root = inflater.inflate(R.layout.score_annuel_fragment, container, false);
        TabLayout tabLayout = root.findViewById(R.id.id_tablayout_annee);
        tabLayout.getTabAt(0).setText("Année en cours");
        tabLayout.getTabAt(1).setText("12 derniers mois");
        final TabItem tabItem = root.findViewById(R.id.tab_item_period1);
        scoreAnnuelViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}
