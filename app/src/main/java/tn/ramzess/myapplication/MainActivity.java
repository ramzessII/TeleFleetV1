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

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Date;

import tn.ramzess.myapplication.business.Score;
import tn.ramzess.myapplication.ui.scores.ScoreFragment;
import tn.ramzess.myapplication.util.TeleFleetUtils;

public class MainActivity extends AppCompatActivity implements LocationListener, View.OnTouchListener {
    private LocationManager locationManager;
    private static int PERMISSION_CALL_ID = 1234;
    private boolean modePrivateEnable = false;
    private boolean userIsIdentified = false;
    private AppBarConfiguration mAppBarConfiguration;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    NavController navController;
    float oldTouchX = 0;
    float oldTouchY = 0;
    boolean ignoreOnTouche = false;

    public int getTypeScore() {
        return typePeriodeScore;
    }

    private int typePeriodeScore;
    private boolean periodeEnCoursOuXDernieresSousPeriode;

    Date dateDebutScoreAnnuel;
    Date dateFinScoreAnnuel;
    Date dateDebutScoreMensuel;
    Date dateFinScoreMensuel;
    Date dateDebutScoreHebdomadaire;
    Date dateFinScoreHebdomadaire;
    Date dateDynamiqueDebutScore;
    Date dateDynamiqueFinScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        typePeriodeScore = Score.SCORE_ANNUEL;
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
        TabLayout tabLayout = findViewById(R.id.id_tablayout_type_periode);
        drawer.setOnTouchListener(this);






        Date dateDynamiqueDebutScore = new Date();
        Date getDateDynamiqueFinScore = new Date();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPermission();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (locationManager == null) {
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
        Toast.makeText(this, "Location " + latitude + "\n" + longitude, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
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

    private void checkPermission() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMISSION_CALL_ID);
            return;
        }
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);
        }
        if (locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);
        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CALL_ID) {
            checkPermission();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int idView = view.getId();
        switch (idView) {
            case R.id.tab_item_periode1:
                switch (typePeriodeScore) {
                    case Score.SCORE_ANNUEL:
                        // Calculer la nouvelle date de début et de fin
                        dateDebutScoreAnnuel = TeleFleetUtils.getFirstDayOfYear(new Date());
                        dateFinScoreAnnuel = TeleFleetUtils.getLastDayOfYear(new Date());
                        break;
                    case Score.SCORE_MENSUEL:
                        dateDebutScoreMensuel = TeleFleetUtils.getFirstDayOfMonth(new Date());
                        dateFinScoreMensuel = TeleFleetUtils.getLastDayOfMonth(new Date());
                        break;
                    case Score.SCORE_HEBDOMADAIRE:
                        dateDebutScoreHebdomadaire = TeleFleetUtils.getFirstDayOfWeek(new Date());
                        dateFinScoreHebdomadaire = TeleFleetUtils.getLastDayOfWeek(new Date());
                        break;
                    case Score.SCORE_JOURNALIER:
                        break;
                }
                break;

            case R.id.tab_item_periode2:
                switch (typePeriodeScore) {
                    case Score.SCORE_ANNUEL:
                        dateFinScoreAnnuel = new Date();
                        dateDebutScoreAnnuel = TeleFleetUtils.getOneYearLater(new Date());
                        break;
                    case Score.SCORE_MENSUEL:
                        dateFinScoreMensuel = new Date();
                        dateDebutScoreMensuel = TeleFleetUtils.getOneMonthLater(new Date());
                        break;
                    case Score.SCORE_HEBDOMADAIRE:
                        dateFinScoreHebdomadaire = new Date();
                        dateDebutScoreHebdomadaire = TeleFleetUtils.getOneWeekLater(new Date());
                        break;
                    case Score.SCORE_JOURNALIER:
                        break;
                }
                break;
            case R.id.id_tablayout_type_score:
                break;
            default:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    oldTouchX = event.getX();
                    oldTouchY = event.getY();
                    if (oldTouchX < 50) {
                        System.out.println("X=" + oldTouchX + " => Trop près du menu" + event.toString());
                        ignoreOnTouche = true;
                        return false;
                    }

                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (ignoreOnTouche) {
                        ignoreOnTouche = false;
                        System.out.println("Show context menu");
                        return false; //Laisser l'evenement au menu sandwich
                    }
                    ignoreOnTouche = false;
                    float upX1 = event.getX();
                    float upY1 = event.getY();

                    float tracetX = oldTouchX - upX1;
                    float tracetY = oldTouchY - upY1;

                    if (Math.abs(tracetX) > Math.abs(tracetY)) // honrizontal
                    {
                        if (tracetX > 100) {

                            onScoreLeftToRighSwipe();
                            return true;
                        } else if (tracetX < -100) {
                            onScoreRighToLeftSwipe();
                            return true;
                        }
                    } else // verticla swipe
                    {
                        if (tracetY > 100) {
                            onScoreBottomToTopSwipe();
                            return true;
                        } else if (tracetY < -100) {
                            onScoreTopToBottomSwipe();
                            return true;
                        }
                    }
                }
        }

        return true;
    }

    public boolean onScoreLeftToRighSwipeWithDate(Date dateDeb, Date dateFin) {
        int idCurrentDestination = navController.getCurrentDestination().getId();
        int idNextDestination;
        switch (idCurrentDestination) {
            case R.id.nav_score_annuel:
                idNextDestination = R.id.nav_score_mensuel;
                navController.navigate(idNextDestination);
                break;
            case R.id.nav_score_mensuel:
                idNextDestination = R.id.nav_score_hebdomadaire;
                navController.navigate(idNextDestination);
                break;
            case R.id.nav_score_hebdomadaire:
                //idNextDestination = R.id.nav_score_annuel;
                //navController.navigate(idNextDestination);
                break;
            default:
                break;
        }
        drawer.refreshDrawableState();
        return true;
    }

    public boolean onScoreLeftToRighSwipe() {
        System.out.println("onLeftToRighSwipe");
        int idCurrentDestination = navController.getCurrentDestination().getId();
        switch (idCurrentDestination) {
            case R.id.nav_score_annuel:
                onScoreLeftToRighSwipeWithDate(getDateDebutScoreAnnuel(), getDateFinScoreAnnuel());
                break;
            case R.id.nav_score_mensuel:
                onScoreLeftToRighSwipeWithDate(getDateDebutScoreHebdomadaire(), getDateFinScoreAnnuel());
                break;
            case R.id.nav_score_hebdomadaire:
                break;
            default:
                break;
        }
        drawer.refreshDrawableState();
        return true;
    }

    public boolean onScoreRighToLeftSwipe() {
        System.out.println("onRighToLeftSwipe");
        int idCurrentDestination = navController.getCurrentDestination().getId();
        int idNextDestination;
        switch (idCurrentDestination) {
            case R.id.nav_score_annuel:
                //idNextDestination = R.id.nav_score_mensuel;
                //navController.navigate(idNextDestination);
                break;
            case R.id.nav_score_mensuel:
                idNextDestination = R.id.nav_score_annuel;
                navController.navigate(idNextDestination);
                break;
            case R.id.nav_score_hebdomadaire:
                idNextDestination = R.id.nav_score_mensuel;
                navController.navigate(idNextDestination);
                break;
            default:
                break;
        }
        drawer.refreshDrawableState();
        return true;
    }

    public boolean onScoreTopToBottomSwipe() {
        System.out.println("onTopToBottomSwipe");
        return true;
    }

    public boolean onScoreBottomToTopSwipe() {
        System.out.println("onBottomToTop Swipe");
        return true;
    }

    public void onChartValueSelected(ScoreFragment callerFragment, Date dateDeb, Date dateFin) {
        switch (typePeriodeScore) {
            case Score.SCORE_ANNUEL:
                break;
            case Score.SCORE_MENSUEL:
                break;
            case Score.SCORE_HEBDOMADAIRE:
                break;
        }
        dateDynamiqueDebutScore = dateDeb;
        dateDynamiqueFinScore = dateFin;
        onScoreLeftToRighSwipeWithDate(dateDeb, dateFin);
    }

    public Date getDateDebutScoreAnnuel() {
        dateDebutScoreAnnuel = TeleFleetUtils.getFirstDayOfYear(new Date());
        return dateDebutScoreAnnuel;
    }

    public Date getDateFinScoreAnnuel() {
        dateFinScoreAnnuel = TeleFleetUtils.getLastDayOfYear(new Date());
        return dateFinScoreAnnuel;
    }


    public Date getDateDebutScoreMensuel() {
        dateDebutScoreMensuel = TeleFleetUtils.getFirstDayOfMonth(new Date());
        return dateDebutScoreMensuel;
    }


    public Date getDateFinScoreMensuel() {
        dateFinScoreMensuel = TeleFleetUtils.getLastDayOfMonth(new Date());
        return dateFinScoreMensuel;
    }

    public Date getDateDebutScoreHebdomadaire() {
        dateDebutScoreHebdomadaire = TeleFleetUtils.getFirstDayOfWeek(new Date());
        return dateDebutScoreHebdomadaire;
    }


    public Date getDateFinScoreHebdomadaire() {
        dateFinScoreHebdomadaire = TeleFleetUtils.getLastDayOfWeek(new Date());
        return dateFinScoreHebdomadaire;
    }


}