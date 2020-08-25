package com.ai.doc.visitor.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class PdfFile extends ResourceFile {
    public PdfFile(String filePath){
        super(filePath);
    }
    @Override
    public void extract2txt() {
        //...
        System.out.println("Extract PDF.");
    }
}
