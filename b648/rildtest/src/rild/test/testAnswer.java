package rild.test;

import java.io.IOException;

public class testAnswer extends testcase {

    public testAnswer()
    {
        num = 1;
        strType = "9";
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
