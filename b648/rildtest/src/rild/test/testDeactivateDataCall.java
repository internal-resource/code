package rild.test;

import java.io.IOException;

public class testDeactivateDataCall extends testcase {

    public testDeactivateDataCall()
    {
        num = 1;
        strType = "7";
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
