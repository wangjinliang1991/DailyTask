package com.ai.doc.memo.v1;

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
    public void setText(String text){
        this.text.replace(0,this.text.length(),text);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
