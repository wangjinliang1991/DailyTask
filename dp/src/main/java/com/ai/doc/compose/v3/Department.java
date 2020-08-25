package com.ai.doc.compose.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class Department extends HumanResource {
    private List<HumanResource> subNodes = new ArrayList<>();
    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource hr: subNodes){
            totalSalary += hr.calculateSalary();
        }
        this.salary = totalSalary;
        return salary;
    }
    public void addSunNode(HumanResource hr){
        subNodes.add(hr);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
