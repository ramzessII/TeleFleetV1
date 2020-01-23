package tn.ramzeess.myapplication.ui.diagnostic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiagnosticViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DiagnosticViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Diagnostic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}