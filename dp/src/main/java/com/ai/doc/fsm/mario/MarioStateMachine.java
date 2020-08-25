package com.ai.doc.fsm.mario;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class MarioStateMachine {
    private int score;
    private State currentState;
    public  MarioStateMachine(){
        this.score = 0;
        this.currentState = State.SMALL;
    }
    public void obtainMushRoom(){
        //todo
    }
    public void obatainCape(){
        //todo
    }
    public void obtainFireFlower(){
        //todo
    }
    public void meetMonster(){
        //todo
    }
    public int getScore(){
        return this.score;
    }
    public State getCurrentState(){
        return this.currentState;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
