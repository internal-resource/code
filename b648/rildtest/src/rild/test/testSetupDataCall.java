package rild.test;

import java.io.IOException;

public class testSetupDataCall extends testcase {

    public testSetupDataCall()
    {
        num = 2;
        strType = "6";
        strBuffer = "default";
    }
    @Override
    public void sendCommand() throws IOException {
        // TODO Auto-generated method stub
        conn = new connectRildDebug();
        conn.send(num);
        conn.send(strType.length());
        conn.send(strType);
        
        conn.send(strBuffer.length());
        conn.send(strBuffer);
        conn.close();
    }

}
