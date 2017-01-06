package jp.techacademy.yumie.minakami.monitoringapp;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import static android.bluetooth.BluetoothAdapter.STATE_CONNECTED;

public class MainActivity extends AppCompatActivity {

    private BluetoothAdapter    mBluetoothAdapter;
    private TextView            mTextView;

    private static final int    BT_REQUEST_ENABLE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getActionBar().setTitle(R.string.app_name);

//        Log.d("life", "onCreate");

        mTextView = (TextView) findViewById(R.id.tvMain);

        // Use this check to determine whether BLE is supported on the device.  Then you can
        // selectively disable BLE-related features.
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, R.string.ble_not_supported, Toast.LENGTH_SHORT).show();
            finish();
        }

        // initialize Bluetooth Adapter
        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        // check Bluetooth supported
        if(mBluetoothAdapter == null){
            Toast.makeText(this, R.string.ble_not_supported, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
//        if(mBluetoothAdapter.isEnabled()){
//            mTextView.setText(R.string.bt_on);
//        } else {
//            mTextView.setText(R.string.bt_off);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("life", "onResume");

        // Ensures Bluetooth is enabled on the device.
        // If Bluetooth is not currently enabled,
        // fire an intent to display a dialog asking the user to grant permission to enable it.
        if (!mBluetoothAdapter.isEnabled()) {
//            mTextView.setText(R.string.bt_off);
//            Log.d("life", "R.string.bt_off @ onResume");
            Intent setBtIntnt = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(setBtIntnt, BT_REQUEST_ENABLE);
//        } else {
//            mTextView.setText(R.string.bt_on);
//            Log.d("life", "R.string.bt_on @ onResume");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//        Log.d("life", "onActivityResult");

        // User chose not to enable Bluetooth.
        if (requestCode == BT_REQUEST_ENABLE && resultCode == Activity.RESULT_CANCELED) {
            finish();
            return;
        }

//        if(mBluetoothAdapter.isEnabled()){
//            mTextView.setText(R.string.bt_on);
//            Log.d("life", "R.string.bt_on @ onActivityResult");
//        } else {
//            mTextView.setText(R.string.bt_off);
//            Log.d("life", "R.string.bt_off @ onActivityResult");
//        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Log.d("life", "onPause");
    }
}
