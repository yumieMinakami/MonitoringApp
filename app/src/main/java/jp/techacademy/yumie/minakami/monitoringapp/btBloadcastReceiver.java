package jp.techacademy.yumie.minakami.monitoringapp;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 2017/01/06.
 */

public class btBloadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        int state = intent.getExtras().getInt(BluetoothAdapter.EXTRA_STATE);

        switch (state){
            case BluetoothAdapter.STATE_OFF:
                // local Bluetooth adapter is off
                Toast.makeText(context, R.string.bt_off, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                // local Bluetooth adapter is turning off
                Toast.makeText(context, R.string.bt_turning_off, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_ON:
                // local Bluetooth adapter is on
                Toast.makeText(context, R.string.bt_on, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_TURNING_ON:
                // local Bluetooth adapter is turning on
                Toast.makeText(context, R.string.bt_turning_on, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_CONNECTED:
                Toast.makeText(context, R.string.bt_state_connected, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_CONNECTING:
                Toast.makeText(context, R.string.bt_state_connecting, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_DISCONNECTED:
                Toast.makeText(context, R.string.bt_state_disconnected, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_DISCONNECTING:
                Toast.makeText(context, R.string.bt_state_disconnecting, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
