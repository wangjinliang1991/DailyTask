package com.ai.doc.fsm.mario.v2;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/18
 * @Version:
 **/
public enum Event {
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);
    private int value;
    private Event(int value){
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
