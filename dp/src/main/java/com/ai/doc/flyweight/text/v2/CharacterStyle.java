package com.ai.doc.flyweight.text.v2;

import java.awt.*;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class CharacterStyle {
    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object obj) {
        CharacterStyle otherStyle = (CharacterStyle) obj;
        return font.equals(otherStyle.font)
                && size==otherStyle.size
                && colorRGB==otherStyle.colorRGB;
    }
    
    
    
    
    
    
    
    
    
    
    
}
