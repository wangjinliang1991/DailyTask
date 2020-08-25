package com.ai.doc.memo.v1;

import java.util.Stack;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class SnapshotHolder {
    private Stack<InputText> snapshots = new Stack<>();
    public InputText popSnapshot(){
        return snapshots.pop();
    }
    public void pushSnapshot(InputText inputText){
        InputText deepClonedInputText = new InputText();
        deepClonedInputText.setText(inputText.getText());
        snapshots.push(deepClonedInputText);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
