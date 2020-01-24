package tn.ramzess.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import tn.ramzess.myapplication.R;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private static int PERMISSION_CALL_ID=1234;
    private boolean modePrivateEnable = false;
    private boolean userIsIdentified = false;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.main_activity_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View btnLogin = findViewById(R.id.buttonLogin);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_compte, R.id.nav_conduite, R.id.nav_diagnostic,
                R.id.nav_parametres, R.id.nav_mainScreen, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavController navController2 = Navigation.findNavController(this, R.id.nav_mainScreen);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController2);

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
}