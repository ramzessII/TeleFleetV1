package tn.ramzess.myapplication.ui.scores;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import tn.ramzess.myapplication.R;
import tn.ramzess.myapplication.business.Chauffeur;
import tn.ramzess.myapplication.business.Score;
import tn.ramzess.myapplication.dao.Database;

public class ScoreViewModel extends ViewModel {

    private Score score;
    private int typePeriodeScore =Score.SCORE_ANNUEL ;
    private int typeSecurite = Score.SCORE_ECO_CONDUIE;
    private boolean periodeEnCoursOuXDernieresSousPeriode;
    Fragment masterFragment;
    private View rootView;

    private MutableLiveData<String> mText;

    ArrayList<Entry> entries = new ArrayList<>();
    LineDataSet dataset = new LineDataSet(entries, "# de Scores");
    ArrayList<String> labels = new ArrayList<String>();



    public ScoreViewModel(View rootView,  int typePeriodeScore, int typeSecurite, Date ddeb, Date dfin) {
        this.typePeriodeScore = typePeriodeScore;
        this.typeSecurite = typeSecurite;
        this.rootView = rootView;
        this.masterFragment = masterFragment;
        mText = new MutableLiveData<>();
        mText.setValue("This is score annuel fragment");

        if(typePeriodeScore == Score.SCORE_ANNUEL ||
                typePeriodeScore == Score.SCORE_MENSUEL ||
                typePeriodeScore == Score.SCORE_HEBDOMADAIRE||
                typePeriodeScore == Score.SCORE_JOURNALIER)
        {
            this.typePeriodeScore = typePeriodeScore;

            TabLayout tabLayout = rootView.findViewById(R.id.id_tablayout_type_periode);
            SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
            String strDeb = spf.format(ddeb);
            String strFin = spf.format(dfin);
            tabLayout.getTabAt(0).setText("Du " + strDeb + "\nAu " + strFin);

           /* switch (typePeriodeScore)
            {
                case Score.SCORE_ANNUEL:
                    tabLayout.getTabAt(0).setText("Année en cours");
                    tabLayout.getTabAt(1).setText("12 derniers mois");
                    break;
                case Score.SCORE_MENSUEL:
                    tabLayout.getTabAt(0).setText("Mois en cours");
                    tabLayout.getTabAt(1).setText("30 derniers jours");
                    break;
                case Score.SCORE_HEBDOMADAIRE:
                    tabLayout.getTabAt(0).setText("Semaine en cours");
                    tabLayout.getTabAt(1).setText("7 derniers jours");
                    break;
                case Score.SCORE_JOURNALIER:
                    break;
            }*/


        }
        Database database = new Database();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        score = database.getScore(new Chauffeur(1, "Bond", "James"),ddeb,dfin,typePeriodeScore,typeSecurite);
        if(score != null) {
            entries = score.getEntries();
            dataset = new LineDataSet(entries, "# de Scores");
            labels = score.getLabels();
            System.out.println("Score retrieved form database");
        }
    }

    public void updateDataWithDate(Date ddeb, Date dfin)
    {
        this.typePeriodeScore = typePeriodeScore;
        mText = new MutableLiveData<>();
        mText.setValue("This is score annuel fragment");

        if(typePeriodeScore == Score.SCORE_ANNUEL ||
                typePeriodeScore == Score.SCORE_MENSUEL ||
                typePeriodeScore == Score.SCORE_HEBDOMADAIRE||
                typePeriodeScore == Score.SCORE_JOURNALIER)
        {
            this.typePeriodeScore = typePeriodeScore;

            TabLayout tabLayout = rootView.findViewById(R.id.id_tablayout_type_periode);

            SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
            String strDeb = spf.format(ddeb);
            String strFin = spf.format(dfin);
            tabLayout.getTabAt(0).setText("From " + strDeb + "\nTo " + strFin);
            /*
            switch (typePeriodeScore)
            {
                case Score.SCORE_ANNUEL:
                    tabLayout.getTabAt(0).setText("Année en cours");
                    tabLayout.getTabAt(1).setText("12 derniers mois");
                    break;
                case Score.SCORE_MENSUEL:
                    tabLayout.getTabAt(0).setText("Mois en cours");
                    tabLayout.getTabAt(1).setText("30 derniers jours");
                    break;
                case Score.SCORE_HEBDOMADAIRE:
                    tabLayout.getTabAt(0).setText("Semaine en cours");
                    tabLayout.getTabAt(1).setText("7 derniers jours");
                    break;
                case Score.SCORE_JOURNALIER:
                    break;
            }*/


        }
        Database database = new Database();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        score = database.getScore(new Chauffeur(1, "Bond", "James"),ddeb,dfin,typePeriodeScore,typeSecurite);
        if(score != null) {
            entries = score.getEntries();
            dataset = new LineDataSet(entries, "# de Scores");
            labels = score.getLabels();
            System.out.println("Score retrieved form database");
        }
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
}
