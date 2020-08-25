package com.ai.doc.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 棋局
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class ChessBoard {
    private Map<Integer, ChessPiece> ChesePiece = new HashMap<>();
    public ChessBoard(){
        init();
    }
    private void init(){
        ChesePiece.put(1,new ChessPiece(1,"车", ChessPiece.Color.BLACK,0,0));
        ChesePiece.put(2,new ChessPiece(2,"车", ChessPiece.Color.BLACK,0,1));
        //...省略摆放其他棋子的代码...
    }
    public void move(int chessPieceId,int toPositionX,int toPositionY){
        //...省略...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
