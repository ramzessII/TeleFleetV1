package tn.ramzess.myapplication.ui.mainscreen;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import tn.ramzess.myapplication.MainActivity;
import tn.ramzess.myapplication.R;
import tn.ramzess.myapplication.business.Score;

public class ScoreFragment extends Fragment implements OnChartValueSelectedListener {

    private ScoreViewModel scoreViewModel;
    private BarChart barChart;
    ArrayList<Entry> entries;
    LineDataSet dataset;
    ArrayList<String> labels;
    LineData data;
    LineChart chart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreViewModel =
                ViewModelProviders.of(this).get(ScoreViewModel.class);
        View root = inflater.inflate(R.layout.score_fragement, container, false);
        int idfragmet = this.getId();
        switch (idfragmet)
        {
            case R.id.fragmentannuel:
                scoreViewModel.updateData(Score.EST_SCORE_ANNUEL);
                break;
            case R.id.fragmentmensuel:
                scoreViewModel.updateData(Score.EST_SCORE_MENSUEL);
                break;
            case R.id.fragmenthebdomadaire:
                scoreViewModel.updateData(Score.EST_SCORE_HEBDOMADAIRE);
                break;
            case R.id.fragmentjournalier:
                scoreViewModel.updateData(Score.EST_SCORE_JOURNALIER);
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
}
