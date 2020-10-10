package location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;

public class Tool {
    private Context context;
    private LocationManager myLocationManager;
    private Location location;
    private Double Longitude;
    private Double Latitude;

    public  Tool(Context context){
        this.context = context;
        this.myLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        ActivityCompat.requestPermissions((Activity) context, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 200);
    }

    public Boolean checkPermission(){
        return ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    public Double getLatitude() {
        if (this.location!=null){
            return this.location.getLongitude();
        }else {
            return 0.0;
        }
    }

    public void initLocation() {
        if (this.checkPermission()){
            this.location = this.myLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
    }
}
