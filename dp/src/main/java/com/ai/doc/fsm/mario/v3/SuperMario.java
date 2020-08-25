package com.ai.doc.fsm.mario.v3;

import com.ai.doc.fsm.mario.State;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class SuperMario implements IMario {
    private MarioStateMachine stateMachine;
    public SuperMario(MarioStateMachine stateMachine){
        this.stateMachine = stateMachine;
    }
    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom() {
        //...do nothing...
    }

    @Override
    public void obtainCape() {
        stateMachine.setCurrentState(new CapeMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore()+200);
    }

    @Override
    public void obtainFireFlower() {
        stateMachine.setCurrentState(new FireMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore()+300);
    }

    @Override
    public void meetMonster() {
        stateMachine.setCurrentState(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore()-100);
    }
}
