package tn.ramzess.myapplication.ui.mainscreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

enum Jour {SUNDAY, MONDAY, TUESDAY, WEDNESDAY,THURSDAY, FRIDAY, SATURDAY}
enum SwitchAnnee {ANNE_EN_COUR,DOUZE_DERNIER_MOIS}
enum Score {ECOCONDUITE,SECURITE}

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