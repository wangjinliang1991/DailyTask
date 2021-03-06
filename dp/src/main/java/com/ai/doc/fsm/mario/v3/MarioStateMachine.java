package com.ai.doc.fsm.mario.v3;

import com.ai.doc.fsm.mario.State;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class MarioStateMachine {
    private int score;
    private IMario currentState;//不再使用枚举类表示状态
    public MarioStateMachine(){
        this.score = 0;
        this.currentState = new SmallMario(this);
    }
    public void obtainMushRoom(){
        this.currentState.obtainMushRoom();
    }
    public void obtainCape(){
        this.currentState.obtainCape();
    }
    public void obtainFireFlower(){
        this.currentState.obtainFireFlower();
    }
    public void meetMonster(){
        this.currentState.meetMonster();
    }
    public int getScore(){
        return this.score;
    }
    public State getCurrentState(){
        return this.currentState.getName();
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setCurrentState(IMario currentState){
        this.currentState = currentState;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
