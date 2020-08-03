package com.ai.doc.chonggou1.metricsv2;

import com.ai.doc.metrics.EmailSender;
import com.ai.doc.metrics.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/3
 * @Version: 1.0
 **/
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();
    public EmailViewer(){
        this.emailSender = new EmailSender();
    }
    public EmailViewer(EmailSender emailSender){
        this.emailSender = emailSender;
    }
    
    public void addToAddress(String address){
        toAddresses.add(address);
    }
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        //format the requestStats to HTML style
        // send it to email toAddresses
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
