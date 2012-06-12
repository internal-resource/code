package rild.test;

import java.io.IOException;

public class testRadioPowerOff extends testcase {

    public testRadioPowerOff()
    {
        num = 1;
        strType = "1";
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
