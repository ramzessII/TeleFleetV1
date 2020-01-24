package tn.ramzess.myapplication.ui.compte;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CompteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Compte fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}