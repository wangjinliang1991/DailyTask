package com.ai.doc.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) {
        InputStream in = new FileInputStream("/xx/xx/test.txt");
        InputStream bin = new BufferedInputStream(in);
        byte[] data = new byte[128];
        while(bin.read(data)!=-1){
            //...
        }
    }
}
