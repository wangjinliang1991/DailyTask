package com.ai.doc.flyweight;

import java.awt.*;

/**
 * @Description: 棋子
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class ChessPiece {
    private int id;
    private String text;
    private Color color;
    private int positionX;
    private int positionY;

    public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public static enum Color{
        RED, BLACK
    }
    //...省略其他属性和getter/setter方法...
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
