package tn.ramzess.myapplication.ui.mainscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import tn.ramzess.myapplication.R;

public class MainScreenFragment extends Fragment {

    private MainScreenViewModel mainScreenViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mainScreenViewModel =
                ViewModelProviders.of(this).get(MainScreenViewModel.class);
        View root = inflater.inflate(R.layout.score_first_screen_fragment, container, false);
        return root;
    }
}