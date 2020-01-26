package tn.ramzess.myapplication.ui.mainscreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainScreenViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public MainScreenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is main screen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}