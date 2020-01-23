package tn.ramzeess.myapplication.ui.compte;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import tn.ramzeess.myapplication.R;

public class CompteFragment extends Fragment {

    private CompteViewModel compteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        compteViewModel =
                ViewModelProviders.of(this).get(CompteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_compte, container, false);

        compteViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                System.out.println(s);
            }
        });

        return root;
    }
}