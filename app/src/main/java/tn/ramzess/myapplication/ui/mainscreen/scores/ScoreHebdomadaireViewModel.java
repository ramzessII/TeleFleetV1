package tn.ramzess.myapplication.ui.mainscreen.scores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreHebdomadaireViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ScoreHebdomadaireViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is score mensuel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
