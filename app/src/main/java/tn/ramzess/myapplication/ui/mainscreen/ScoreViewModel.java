package tn.ramzess.myapplication.ui.mainscreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import tn.ramzess.myapplication.business.Chauffeur;
import tn.ramzess.myapplication.business.Score;
import tn.ramzess.myapplication.dao.Database;

public class ScoreViewModel extends ViewModel {

    private int typeScore =0 ;
    private boolean periodeEnCoursOuXDernieresSousPeriode;

    private MutableLiveData<String> mText;

    ArrayList<Entry> entries = new ArrayList<>();
    LineDataSet dataset = new LineDataSet(entries, "# de Scores");
    ArrayList<String> labels = new ArrayList<String>();
    Score score;// = new Score(Score.EST_SCORE_MENSUEL,Score.PERIODE_EN_COURS_OU_X_DERNIERS_SOUS_PERIODE);;

    public ScoreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is score annuel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LineDataSet getDataset() {
        return dataset;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void updateData(int typeScore)
    {
        this.typeScore = typeScore;
        Database database = new Database();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        Date dateDeb= new Date();
        Date dateFin = new Date();
        try {
            dateDeb = sdf.parse("01/01/2019");
            dateFin = sdf.parse("31/12/2019");
        } catch (Exception e) {

            e.printStackTrace();
        }

        Score score;// = new Score(Score.EST_SCORE_MENSUEL,Score.PERIODE_EN_COURS_OU_X_DERNIERS_SOUS_PERIODE);
        score = database.getScore(new Chauffeur(1, "Bond", "James"),dateDeb,dateFin,typeScore);
        if(score != null) {
            entries = score.getEntries();
            dataset = new LineDataSet(entries, "# de Scores");
            labels = score.getLabels();
            System.out.println("Score retrieved form database");
        }
    }
}
