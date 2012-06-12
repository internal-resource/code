package rild.test;

import java.io.IOException;

public class testQXDMlogEnable extends testcase {

    public testQXDMlogEnable()
    {
        num = 1;
        strType = "3";
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
