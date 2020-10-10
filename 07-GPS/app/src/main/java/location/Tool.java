package location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;



public class Tool {
    private Context context;
    private LocationManager myLocationManager;
    private Location location;


    public  Tool(Context context){
        this.context = context;
        this.myLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        ActivityCompat.requestPermissions((Activity) context, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        this.initLocation();
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
        if (this.location==null){
            myLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    Toast.makeText(Tool.this.context, "位置更新", Toast.LENGTH_LONG).show();
                    Tool.this.location = location;
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    Toast.makeText(Tool.this.context, "状态改变", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onProviderEnabled(String provider) {
                    Toast.makeText(Tool.this.context, "位置可用"+provider, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onProviderDisabled(String provider) {
                    Toast.makeText(Tool.this.context, "位置禁用", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
