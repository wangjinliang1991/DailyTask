package com.ai.dm01.oop;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/7/25
 * @Version: 1.0
 **/
public class Wallet {
    /*private String id;
    private long createTime;
    private BigDecimal balance;
    private long balanceLastModifiedTime;
    // ... 省略其他属性...
    
    public Wallet(){
        this.id = IdGenerator.getInstance().generate();
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
    
    public String getId(){
        return this.id;
    }
    
    public long getCreateTime(){
        return this.createTime;
    }
    
    public BigDecimal getBalance(){
        return this.balance;
    }
    
    public long getBalanceLastModifiedTime(){
        return this.balanceLastModifiedTime;
    }
    
    public void increaseBalance(BigDecimal increasedAmount){
        if (increasedAmount.compareTo(BigDecimal.ZERO)<0){
            throw new InvalidAmountException("...");
        }
        this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
    
    public void decreaseBalance(BigDecimal decreaseAmount){
        if (decreaseAmount.compareTo(BigDecimal.ZERO)<0){
            throw new InvalidAmountException("...");
        }
        if (decreaseAmount.compareTo(balance)>0){
            throw new InsufficientAmountException("...");
        }
        this.balance.subtract(decreaseAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }*/
}
