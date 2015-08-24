package metropolia.org.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    LocationManager myLocManager;
    LocationListener myLocListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        myLocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        myLocListener = new MyLocationListener();

        myLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocListener);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        myLocManager.removeUpdates(myLocListener);
    }

    public class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            String coordinates = "My coordinates are: "+location.getLatitude()+ " - "+ location.getLongitude();
            Toast.makeText(getBaseContext(), coordinates, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(getBaseContext(), "Location is enabled", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(getBaseContext(), "Location is disabled", Toast.LENGTH_LONG).show();
        }
    }
}
