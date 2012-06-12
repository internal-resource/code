package rild.test;

import java.io.IOException;

public abstract class testcase {

    protected int num;
    protected String strType;
    protected String strBuffer;
    protected connectType conn = null;
    
    public abstract void sendCommand() throws IOException;
}
