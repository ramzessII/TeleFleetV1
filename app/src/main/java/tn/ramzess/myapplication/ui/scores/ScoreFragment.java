package tn.ramzess.myapplication.ui.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import tn.ramzess.myapplication.MainActivity;
import tn.ramzess.myapplication.R;
import tn.ramzess.myapplication.business.Score;

public class ScoreFragment extends Fragment implements OnChartValueSelectedListener, View.OnClickListener {

    private ScoreViewModel scoreViewModel;
    private BarChart barChart;
    ArrayList<Entry> entries;
    LineDataSet dataset;
    ArrayList<String> labels;
    LineData data;
    LineChart chart;
    int typePeriodeScore = Score.SCORE_ANNUEL;
    int typeScore = Score.SCORE_ECO_CONDUIE;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreViewModel =
                ViewModelProviders.of(this).get(ScoreViewModel.class);
        View root = inflater.inflate(R.layout.score_fragement, container, false);
        int idfragmet = this.getId();
        switch (idfragmet)
        {
            case R.id.fragmentannuel:
                scoreViewModel.updateData(Score.SCORE_ANNUEL,Score.SCORE_ECO_CONDUIE);
                break;
            case R.id.fragmentmensuel:
                scoreViewModel.updateData(Score.SCORE_MENSUEL,Score.SCORE_ECO_CONDUIE);
                break;
            case R.id.fragmenthebdomadaire:
                scoreViewModel.updateData(Score.SCORE_HEBDOMADAIRE,Score.SCORE_ECO_CONDUIE);
                break;
            case R.id.fragmentjournalier:
                scoreViewModel.updateData(Score.SCORE_JOURNALIER,Score.SCORE_ECO_CONDUIE);
                break;
        }

        entries = scoreViewModel.getEntries();
        dataset = scoreViewModel.getDataset();
        labels = scoreViewModel.getLabels();
        data = new LineData(labels, dataset);
        chart = root.findViewById(R.id.chart1);
        chart.setData(data);
        chart.setDescription("# est le score que vous avez éffectué");
        chart.setOnChartValueSelectedListener(this);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void initialise(int typePeriodeScore, View calledby)
    {
        if(typePeriodeScore == Score.SCORE_ANNUEL ||
                typePeriodeScore == Score.SCORE_MENSUEL ||
                typePeriodeScore == Score.SCORE_HEBDOMADAIRE||
                typePeriodeScore == Score.SCORE_JOURNALIER)
        {
            this.typePeriodeScore = typePeriodeScore;

            TabLayout tabLayout = calledby.findViewById(R.id.id_tablayout_type_periode);
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
            }


        }

    }
    @Override
    public void onValueSelected(Entry entry, int dataSetIndex, Highlight h) {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        try {
            String selectedPeriod = labels.get(entry.getXIndex());
            SimpleDateFormat spf = new SimpleDateFormat("y/M/yyyy");
            Date dateDeb = spf.parse(selectedPeriod);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateDeb);
            Date dateFin = new Date();
            int idfragmet = this.getId();
            switch (idfragmet)
            {
                case R.id.fragmentannuel:
                    cal.add(Calendar.MONTH, 1);
                    dateFin = cal.getTime();
                    break;
                case R.id.fragmentmensuel:
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    dateFin = cal.getTime();
                    break;
                case R.id.fragmenthebdomadaire:
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    dateFin = cal.getTime();
                    break;
                case R.id.fragmentjournalier:
                    break;
            }
            System.out.println("Selected period="+selectedPeriod.toString());
            ((MainActivity)getActivity()).onChartValueSelected(this,dateDeb,dateFin);


        }
        catch(Exception e){e.printStackTrace();}


    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onClick(View view)
    {
        int idView = view.getId();
        switch (idView)
        {
            case R.id.tab_item_periode1:
                switch (typePeriodeScore) {
                    case Score.SCORE_ANNUEL:
                        // Calculer la nouvelle date de début et de fin
                        break;
                    case Score.SCORE_MENSUEL:
                        // Calculer la nouvelle date de début et de fin
                        break;
                    case Score.SCORE_HEBDOMADAIRE:
                        // Calculer la nouvelle date de début et de fin
                        break;
                    case Score.SCORE_JOURNALIER:
                        break;
                }
            case R.id.tab_item_periode2: {
                switch (typePeriodeScore) {
                    case Score.SCORE_ANNUEL:
                        // Calculer la nouvelle date de début et de fin
                        break;
                    case Score.SCORE_MENSUEL:
                        // Calculer la nouvelle date de début et de fin
                        break;
                    case Score.SCORE_HEBDOMADAIRE:
                        // Calculer la nouvelle date de début et de fin
                        break;
                    case Score.SCORE_JOURNALIER:
                        break;
                }
            }
            case R.id.id_tablayout_type_score:
            {

            }


        }
    }



}
