
package rild.test;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;

import java.io.IOException;

public class RildtestActivity extends Activity implements OnItemClickListener {

    static final String SOCKET_NAME_RIL = "rild-debug";

    testcase tc = null;

    static final String[] datas = {
            "Dial Call(10086)", "Answer Call", "End Call", "Reset Radio", "Radio Power Off",
            "Unsolicited Network Change", "QXDM log Enable", "QXDM log Disable", "Radio On",
            "Setup Data Call", "Deactivate Data Call", "Exit"
    };

    ListView lv = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lv = new ListView(this);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));
        lv.setOnItemClickListener(this);
        setContentView(lv);

        // setContentView(R.layout.main);

        TelephonyManager tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener listener = new PhoneStateListener() {

            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                // TODO Auto-generated method stub

                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:
                        setTitle(incomingNumber);
                        tc = new testAnswer();
                        try {
                            tc.sendCommand();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }

                //super.onCallStateChanged(state, incomingNumber);
            }

        };

        tManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        switch (arg2) {
            case 0:
                tc = new testDia();
                break;
            case 1:
                tc = new testAnswer();
                break;
            case 2:
                tc = new testHangup();
                break;
            case 3:
                tc = new testResetRadio();
                break;
            case 4:
                tc = new testRadioPowerOff();
                break;
            case 5:
                tc = new testUnsolicitedNetworkChange();
                break;
            case 6:
                tc = new testQXDMlogEnable();
                break;
            case 7:
                tc = new testQXDMlogDisable();
                break;
            case 8:
                tc = new testRadioOn();
                break;
            case 9:
                tc = new testSetupDataCall();
                break;
            case 10:
                tc = new testDeactivateDataCall();
                break;
            case 11:
                finish();
                break;
            default:
                break;
        }
        try {
            tc.sendCommand();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
