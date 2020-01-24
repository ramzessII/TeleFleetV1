package tn.ramzess.myapplication.ui.conduite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConduiteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConduiteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Conduite fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}