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

import java.util.ArrayList;

import tn.ramzess.myapplication.MainActivity;
import tn.ramzess.myapplication.R;

public class ScoreFragment extends Fragment implements OnChartValueSelectedListener {

    private ScoreViewModel scoreViewModel;
    private BarChart barChart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scoreViewModel =
                ViewModelProviders.of(this).get(ScoreViewModel.class);
        View root = inflater.inflate(R.layout.score_fragement, container, false);

        ArrayList<Entry> entries = scoreViewModel.getEntries();
        LineDataSet dataset = scoreViewModel.getDataset();
        ArrayList<String> labels = scoreViewModel.getLabels();
        LineData data = new LineData(labels, dataset);
        LineChart chart = root.findViewById(R.id.chart1);
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
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        ((MainActivity)getActivity()).onChartValueSelected(e, dataSetIndex, h);
    }

    @Override
    public void onNothingSelected() {

    }
}
