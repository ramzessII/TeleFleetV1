package tn.ramzess.myapplication.ui.mainscreen.scores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreMensuelViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ScoreMensuelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is score mensuel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
