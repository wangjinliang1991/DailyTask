package com.ai.doc.memo.v2;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class InputText {
    private StringBuilder text = new StringBuilder();
    public String getText(){
        return text.toString();
    }
    public void append(String input){
        text.append(input);
    }
    public Snapshot createSnapshot(){
        return new Snapshot(text.toString());
    }
    public void restoreSnapshot(Snapshot snapshot){
        this.text.replace(0,this.text.length(),snapshot.getText());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
