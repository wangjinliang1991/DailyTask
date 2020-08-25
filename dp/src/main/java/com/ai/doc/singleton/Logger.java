package com.ai.doc.singleton;

import java.io.File;
import java.io.FileWriter;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class Logger {
    private FileWriter writer;
    private static final Logger instance = new Logger();
    
    public Logger(){
        File file = new File("xxx/xx/log.txt");
        writer = new FileWriter(file,true);//true表示追加写入
    }
    
    public static Logger getInstance(){
        return instance;
    }
    
    public void log(String message){
        writer.write(message);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
