package com.ai.doc.compose.v2;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();
    public abstract long countSizeOfFile();
    public String getPath(){
        return path;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
