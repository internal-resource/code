package rild.test;

import java.io.IOException;

public abstract class connectType {
    
    public abstract void send(String str) throws IOException;
    public abstract void send(int str) throws IOException;
    
    public abstract void close();
    
    public byte[] toLH(int n) {

        byte[] b = new byte[4];

        b[0] = (byte) (n & 0xff);

        b[1] = (byte) (n >> 8 & 0xff);

        b[2] = (byte) (n >> 16 & 0xff);

        b[3] = (byte) (n >> 24 & 0xff);

        return b;

    }
}
