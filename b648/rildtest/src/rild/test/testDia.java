package rild.test;

import java.io.IOException;

public class testDia extends testcase {
            
    public testDia()
    {
        num = 2;
        strType = "8";
        strBuffer = "10086";
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
