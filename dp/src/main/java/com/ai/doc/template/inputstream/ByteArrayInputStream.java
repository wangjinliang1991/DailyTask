package com.ai.doc.template.inputstream;

import java.io.IOException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public class ByteArrayInputStream extends InputStream {
    //...省略其他代码...
    private int pos;
    private int count;
    private byte[] buf;
    @Override
    public synchronized int read() throws IOException {
        return (pos < count)?(buf[pos++] & 0xff):-1;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
