package tn.ramzess.myapplication.ui.mainscreen.scores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreAnnuelViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ScoreAnnuelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is score annuel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
