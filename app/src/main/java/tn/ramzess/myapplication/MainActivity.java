package tn.ramzess.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import tn.ramzess.myapplication.business.Score;

public class MainActivity extends AppCompatActivity implements LocationListener, View.OnTouchListener  {
    private LocationManager locationManager;
    private static int PERMISSION_CALL_ID=1234;
    private boolean modePrivateEnable = false;
    private boolean userIsIdentified = false;
    private AppBarConfiguration mAppBarConfiguration;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    NavController navController;

    private int typeScore;
    private boolean periodeEnCoursOuXDernieresSousPeriode;

    BarChart chart ;
    ArrayList<BarEntry> chartValues ;
    ArrayList<String> chartLabels ;
    BarDataSet barDataSet ;
    BarData chartDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        typeScore = Score.EST_SCORE_ANNUEL;
        periodeEnCoursOuXDernieresSousPeriode = false;

        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.main_activity_drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_compte, R.id.nav_conduite, R.id.nav_diagnostic,
                R.id.nav_parametres, R.id.nav_score_annuel, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        drawer.setOnTouchListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPermission();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(locationManager == null)
        {
            locationManager.removeUpdates(this);
        }
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Toast.makeText(this,"Location " + latitude+ "\n"+ longitude, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int itemId = item.getItemId();
        switch (itemId)
        {
            case R.id.item_private_mode:
                modePrivateEnable = !modePrivateEnable;
                item.setChecked(modePrivateEnable);
                break;
            case R.id.item_setting2:
                item.setChecked(!item.isChecked());
                break;
            case R.id.item_setting3:
                item.setChecked(!item.isChecked());
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onClickBtnSignIn(View view)
    {
        Toast.makeText(this, "onClickBtnSignIn", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnRegister(View view)
    {
        Toast.makeText(this, "onClickBtnRegister", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnLogin(View view)
    {
        Toast.makeText(this, "onClickBtnLogin", Toast.LENGTH_SHORT).show();
    }
    public void onClickBtnFacebook(View view)
    {
        Toast.makeText(this, "onClickBtnFacebook", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnGoogle(View view)
    {
        Toast.makeText(this, "onClickBtnGoogle", Toast.LENGTH_SHORT).show();
    }

    private void checkPermission()
    {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMISSION_CALL_ID);
            return;
        }
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);
        }
        if(locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER))
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10,this);
        }
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10,this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==PERMISSION_CALL_ID)
        {
            checkPermission();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println("1. Touche event detected");
        //int action = event.getAction();
        System.out.println("1. Event action : ");
//        System.out.println("Action Event : " );
//        int idCurrentDestination = navController.getCurrentDestination().getId();
//        int idNextDestination;
//        switch (idCurrentDestination)
//        {
//            case R.id.nav_score_annuel:
//                idNextDestination = R.id.nav_score_mensuel;
//                //navController.navigate(idNextDestination);
//                typeScore = Score.EST_SCORE_MENSUEL;
//                break;
//            case R.id.nav_score_mensuel:
//                idNextDestination = R.id.nav_score_hebdomadaire;
//               // navController.navigate(idNextDestination);
//                typeScore = Score.EST_SCORE_HEBDOMADAIRE;
//                break;
//            case R.id.nav_score_hebdomadaire:
//            /*    idNextDestination = R.id.nav_score_annuel;
//                navController.navigate(idNextDestination);
//                typeScore = Score.EST_SCORE_ANNUEL;*/
//                break;
//            default:
//                break;
//        }
        return true;
    }

    public void onChartValueSelected(Entry e, int dataSetIndex, Highlight h)
    {
        System.out.println("Chart : La9ad tama e5tiyar charta dataset="+dataSetIndex + "Entry =" + e.toString());
    }
}


