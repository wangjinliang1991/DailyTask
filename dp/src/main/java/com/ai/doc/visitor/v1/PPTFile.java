package com.ai.doc.visitor.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class PPTFile extends ResourceFile {
    public PPTFile(String filePath){
        super(filePath);
    }
    @Override
    public void extract2txt() {
        //...省略从ppt中抽取文本的代码...
        //...将抽取的文本保存在跟filePath同名的.txt文件中...
        System.out.println("Extract PPT.");
    }
    
    
    
    
    
    
    
    
    
    
}
