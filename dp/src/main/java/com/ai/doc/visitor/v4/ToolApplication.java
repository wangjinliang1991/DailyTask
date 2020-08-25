package com.ai.doc.visitor.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class ToolApplication {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        for (ResourceFile resourceFile:resourceFiles){
            resourceFile.accept(extractor);
        }
        
        Compressor compressor = new Compressor();
        for (ResourceFile resourceFile:resourceFiles){
            resourceFile.accept(compressor);
        }
    }
    private static List<ResourceFile> listAllResourceFiles(String arg) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀（pdf/ppt/word）由工厂方法创建不同的类对象
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
