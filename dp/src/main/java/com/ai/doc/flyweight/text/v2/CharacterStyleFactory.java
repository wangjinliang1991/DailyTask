package com.ai.doc.flyweight.text.v2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class CharacterStyleFactory {
    private static final List<CharacterStyle> styles = new ArrayList<>();
    public static CharacterStyle getStyle(Font font,int size,int colorRGB){
        CharacterStyle newStyle = new CharacterStyle(font,size,colorRGB);
        for (CharacterStyle style:styles){
            if (style.equals(newStyle)){
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
