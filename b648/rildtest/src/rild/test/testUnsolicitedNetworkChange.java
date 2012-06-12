package rild.test;

import java.io.IOException;

public class testUnsolicitedNetworkChange extends testcase {

    public testUnsolicitedNetworkChange()
    {
        num = 1;
        strType = "2";
    }
    @Override
    public void sendCommand() throws IOException {
        // TODO Auto-generated method stub
        conn = new connectRildDebug();
        conn.send(num);
        conn.send(strType.length());
        conn.send(strType);
        conn.close();
    }

}
