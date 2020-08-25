package com.ai.doc.fsm.mario.v2;

import com.ai.doc.fsm.mario.State;

import static com.ai.doc.fsm.mario.State.CAPE;
import static com.ai.doc.fsm.mario.State.FIRE;
import static com.ai.doc.fsm.mario.State.SMALL;
import static com.ai.doc.fsm.mario.State.SUPER;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class MarioStateMachine {
    private int score;
    private State currentState;
    private static final State[][] transitionTable = {
            {SUPER,CAPE,FIRE,SMALL},
            {SUPER,CAPE,FIRE,SMALL},
            {CAPE,CAPE,CAPE,SMALL},
            {FIRE,FIRE,FIRE,SMALL},
    };
    private static final int[][] actionTable = {
            {+100,+200,+300,+0},
            {+0,+200,+300,-100},
            {+0,+0,+0,-200},
            {+0,+0,+0,-300},
    };
    public MarioStateMachine(){
        this.score = 0;
        this.currentState = SMALL;
    }
    public void obtainMushRoom(){
        executeEvent(Event.GOT_MUSHROOM);
    }
    public void obatainCape(){
        executeEvent(Event.GOT_CAPE);
    }
    public void obtainFireFlower(){
        executeEvent(Event.GOT_FIRE);
    }
    public void meetMonster(){
        executeEvent(Event.MET_MONSTER);
    }
    
    private void executeEvent(Event event){
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score = actionTable[stateValue][eventValue];
    }
    public int getScore(){
        return this.score;
    }
    public State getCurrentState(){
        return this.currentState;
    }
    
    
    
    
    
    
    
    
    
    
    
}
