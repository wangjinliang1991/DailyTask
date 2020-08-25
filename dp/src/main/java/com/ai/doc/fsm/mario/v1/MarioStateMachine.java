package com.ai.doc.fsm.mario.v1;

import com.ai.doc.fsm.mario.State;

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
       if (currentState.equals(State.SMALL)){
           this.currentState = State.SUPER;
           this.score += 100;
       }
    }
    public void obatainCape(){
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)){
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }
    public void obtainFireFlower(){
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)){
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }
    public void meetMonster(){
        if (currentState.equals(State.SUPER)){
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }
        if (currentState.equals(State.CAPE)){
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if (currentState.equals(State.FIRE)){
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }
    public int getScore(){
        return this.score;
    }
    public State getCurrentState(){
        return this.currentState;
    }
}