package com.ai.dm01.doc;

import com.ai.dm01.junit.Transaction;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * (what) Bean factory to create beans
 * 
 * (why) The class likes Spring IOC framework, but is more lightweight
 * 
 * (how) Create objects from different sources sequentially
 * use specified object > SPI > configuration > default object
 **/
public class BeansFactory {
    /*public void invest(long userId,long financialProductId){
        if (isLastDayOfMonth(new Date())){
            return;
        }
        //...
    }
    
    public boolean isLastDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,(calendar.get(Calendar.DATE)+1));
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;
    }
    
    public void buyCourse(long userId,long courseId,boolean isVip);
    
    //拆分为两个方法
    public void buyCourse(long userId,long courseId);
    public void buyCourse4Vip(long userId,long courseId,boolean isVip);
    
    public List<Transaction> selectTransactions(Long userId,Date startDate,Date endDate){
        if (startDate != null && endDate != null){
            //查询两个时间区间的transactions
        }
        if (startDate != null && endDate == null){
            //查询startDate之后所有transactions
        }
        if (startDate == null && endDate != null){
            //查询endDate 之前所有transactions
        }
        if (startDate == null && endDate == null){
            //查询所有transactions
        }
    }
    
    //拆分为多个public方法，更清晰易用
    public List<Transaction> selectTransactionsBetween(Long userId,Date startDate,Date endDate){
        return selectTransactions(userId, startDate, endDate);
    }

    public List<Transaction> selectTransactionsStartWith(Long userId,Date startDate){
        return selectTransactions(userId, startDate, null);
    }

    public List<Transaction> selectTransactionsEndWith(Long userId,Date endDate){
        return selectTransactions(userId, null, endDate);
    }

    public List<Transaction> selectAllTransaction(Long userId){
        return selectTransactions(userId, null, null);
    }

    private List<Transaction> selectTransactions(Long userId,Date startDate,Date endDate){
        //...
    }
    
    public double caculateTotalAmount(List<Order> orders){
        if (orders == null || orders.isEmpty()){
            return 0.0;
        }else{//此处的else可以去掉
            //...主逻辑
        }
    }
    */
    
    
    
    
    
    
    
    
    
    
    
}
