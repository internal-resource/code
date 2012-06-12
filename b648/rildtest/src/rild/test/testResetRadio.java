package rild.test;

import java.io.IOException;

public class testResetRadio extends testcase {

    public testResetRadio()
    {
        num = 1;
        strType = "0";
    }
    @Override
    public void sendCommand() throws IOException {
        // TODO Auto-generated method stub

        conn = new connectRildDebug();
        
        conn.send(num);
        conn.send(strType.length());
        
        conn.send(strType);
    }

}
