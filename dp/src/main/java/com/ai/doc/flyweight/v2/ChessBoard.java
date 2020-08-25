package com.ai.doc.flyweight.v2;

import com.ai.doc.flyweight.ChessPieceUnitFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class ChessBoard {
    private Map<Integer,ChessPiece> chessPieces = new HashMap<>();
    public ChessBoard(){
        init();
    }
    private void init(){
        chessPieces.put(1,new ChessPiece(ChessPieceUnitFactory.getChessPiece(1),0,0));
        chessPieces.put(1,new ChessPiece(ChessPieceUnitFactory.getChessPiece(2),1,0));
        //...省略摆放其他棋子的代码...
    }
    public void move(int chessPieceId,int toPositionX,int toPositionY){
        //...省略...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
