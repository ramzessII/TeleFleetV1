package tn.ramzeess.myapplication.ui.parametres;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParametresViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ParametresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Parametres fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}