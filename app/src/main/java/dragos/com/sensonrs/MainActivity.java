package dragos.com.sensonrs;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "Sensor";
    Sensor sensorAccelerator;
    SensorManager sensorManager;
    ;

    Sensor deLumina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        sensorsInit();
//        checkSensors();
        sensorLight();
    }

    void sensorsInit() {

        sensorAccelerator = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensorAccelerator, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
//        Log.v(TAG, "Sensor Changed");
//        Log.v(TAG, "Sensor = " + sensorEvent.sensor.getName());
//        String values = "";

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.v(TAG, "Vendor" + sensor.getVendor());
    }

    void checkSensors() {

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s : sensorList) {
            Log.v(TAG, String.format("Name:%s, Vendor:%s, Type:%d", s.getName(), s.getVendor(), s.getType()));
        }

    }

    void sensorLight() {
        deLumina = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, deLumina, SensorManager.SENSOR_DELAY_NORMAL);
//        Log.v(TAG, deLumina.)
    }

}
