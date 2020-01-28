package tn.ramzess.myapplication.ui.scores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

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

        View root = inflater.inflate(R.layout.score_fragement, container, false);
        int idfragmet = this.getId();
        Date now = new Date();
        Date ddeb = new Date();
        Date dfin = new Date();
        switch (idfragmet)
        {
            case R.id.fragmentannuel:
                ddeb = ((MainActivity) getActivity()).getDateDebutScoreAnnuel();
                dfin = ((MainActivity) getActivity()).getDateFinScoreAnnuel();
                scoreViewModel = new ScoreViewModel(root,Score.SCORE_ANNUEL,Score.SCORE_ECO_CONDUIE,ddeb,dfin);
                break;
            case R.id.fragmentmensuel:
                ddeb = ((MainActivity) getActivity()).getDateDebutScoreMensuel();
                dfin = ((MainActivity) getActivity()).getDateFinScoreMensuel();
                scoreViewModel = new ScoreViewModel(root,Score.SCORE_MENSUEL,Score.SCORE_ECO_CONDUIE,ddeb,dfin);
                break;
            case R.id.fragmenthebdomadaire:
                ddeb = ((MainActivity) getActivity()).getDateDebutScoreHebdomadaire();
                dfin = ((MainActivity) getActivity()).getDateFinScoreHebdomadaire();
                scoreViewModel = new ScoreViewModel(root,Score.SCORE_HEBDOMADAIRE,Score.SCORE_ECO_CONDUIE,ddeb,dfin);
                break;
            case R.id.fragmentjournalier:
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

    public ScoreViewModel getScoreViewModel() {
        return scoreViewModel;
    }

    @Override
    public void onValueSelected(Entry entry, int dataSetIndex, Highlight h) {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        try {
            String selectedPeriod = labels.get(entry.getXIndex());
            SimpleDateFormat spf = new SimpleDateFormat("d/M/yyyy");
            Date dateDeb = spf.parse(selectedPeriod);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateDeb);
            Date dateFin = new Date();
            int idfragmet = this.getId();
            switch (idfragmet)
            {
                case R.id.fragmentannuel:
                    System.out.println("Selected period fragment annuel="+selectedPeriod.toString());
                    cal.add(Calendar.MONTH, 1);
                    dateFin = cal.getTime();
                    break;
                case R.id.fragmentmensuel:
                    System.out.println("Selected period fragment mensuel="+selectedPeriod.toString());
                    cal.add(Calendar.WEEK_OF_MONTH, 1);
                    dateFin = cal.getTime();
                    break;
                case R.id.fragmenthebdomadaire:
                    System.out.println("Selected period fragment hebdomadaire="+selectedPeriod.toString());
                    cal.add(Calendar.DAY_OF_WEEK, 1);
                    dateFin = cal.getTime();
                    break;
                case R.id.fragmentjournalier:
                    break;
                    default:
                        System.out.println("Selected period default="+selectedPeriod.toString());
            }

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
