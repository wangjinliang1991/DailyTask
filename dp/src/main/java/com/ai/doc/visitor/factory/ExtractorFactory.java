package com.ai.doc.visitor.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class ExtractorFactory {
    private static final Map<ResourceFileType,Extractor> extractors = new HashMap<>();
    static {
        extractors.put(ResourceFileType.PDF,new PdfExtractor());
        extractors.put(ResourceFileType.PPT,new PPTExtractor());
        extractors.put(ResourceFileType.WORD,new WordExtractor());
    }
    public static Extractor getExtractor(ResourceFileType type){
        return extractors.get(type);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
