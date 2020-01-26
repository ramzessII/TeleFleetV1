package tn.ramzess.myapplication.ui.mainscreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import tn.ramzess.myapplication.business.Score;

public class ScoreViewModel extends ViewModel {

    private int typeScore;
    private boolean periodeEnCoursOuXDernieresSousPeriode;

    private MutableLiveData<String> mText;
    private Score score = new Score(Score.EST_SCORE_MENSUEL,Score.PERIODE_EN_COURS_OU_X_DERNIERS_SOUS_PERIODE);

    public ScoreViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is score annuel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LineDataSet getDataset() {
        return score.getDataset();
    }

    public ArrayList<String> getLabels() {
        return score.getLabels();
    }

    public ArrayList<Entry> getEntries() {
        return score.getEntries();
    }
}
