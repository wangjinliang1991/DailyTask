package com.ai.doc.memo.v2;

import java.util.Stack;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();
    public Snapshot popSnapshot(){
        return snapshots.pop();
    }
    public void pushSnapshot(Snapshot snapshot){
        snapshots.push(snapshot);
    }
    
    
    
    
    
    
    
    
}
