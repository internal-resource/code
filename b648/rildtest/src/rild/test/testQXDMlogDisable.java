package rild.test;

import java.io.IOException;

public class testQXDMlogDisable extends testcase {

    public testQXDMlogDisable()
    {
        num = 1;
        strType = "4";
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
