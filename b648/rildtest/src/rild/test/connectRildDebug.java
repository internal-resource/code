package rild.test;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

public class connectRildDebug extends connectType {
    static final String SOCKET_NAME_RIL = "rild-debug";
    
    LocalSocket s = null;
    LocalSocketAddress l = null;
    OutputStream os = null;
    DataOutputStream dos = null;
    
    public connectRildDebug()
    {
        s = new LocalSocket();
        l = new LocalSocketAddress(SOCKET_NAME_RIL, LocalSocketAddress.Namespace.RESERVED);
 
        try {
            os = s.getOutputStream();
            s.connect(l);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dos = new DataOutputStream(os);
    }

    @Override
    public void send(String str) throws IOException {
        // TODO Auto-generated method stub

        os.write(str.getBytes());
        os.flush();
    }

    @Override/*
    public void send(int str) throws IOException {
        // TODO Auto-generated method stub

        dos.writeInt(str);
        dos.flush();
    }*/
    public void send(int str) throws IOException {
        // TODO Auto-generated method stub

        os.write(toLH(str));
        os.flush();
    }
    
    @Override
    public void close() {
        // TODO Auto-generated method stub
        try {
            s.close();
            os.close();
       
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
