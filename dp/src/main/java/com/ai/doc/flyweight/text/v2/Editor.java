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
public class Editor {
    private List<Character> chars = new ArrayList<>();
    public void appendCharacter(char c, Font font, int size, int colorRGB){
        Character character = new Character(c,CharacterStyleFactory.getStyle(font, size, colorRGB));
        chars.add(character);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
