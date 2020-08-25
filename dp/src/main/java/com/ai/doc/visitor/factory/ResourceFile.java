package com.ai.doc.visitor.factory;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public abstract class ResourceFile {
    protected String filePath;
    public ResourceFile(String filePath){
        this.filePath = filePath;
    }
    public abstract ResourceFileType getType();
}
