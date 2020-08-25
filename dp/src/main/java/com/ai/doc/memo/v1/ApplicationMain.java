package com.ai.doc.memo.v1;

import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class ApplicationMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            if (input.equals(":list")){
                System.out.println(inputText.toString());
            }else if (input.equals(":undo")){
                InputText snapshot = snapshotHolder.popSnapshot();
                inputText.setText(snapshot.getText());
            }else{
                snapshotHolder.pushSnapshot(inputText);
                inputText.append(input);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
