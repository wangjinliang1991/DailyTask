package com.ai.doc.chonggou1;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/2
 * @Version: 1.0
 **/
public class RandomIdGenrator implements IdGenerator{
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenrator.class);
    @Override
    public String generate() throws IdGenerationFailureException{
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastfiledOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s",substrOfHostName,currentTimeMillis,randomString);
        return id;
    }
    
    private String getLastfiledOfHostName() throws UnknownHostException{
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName==null || hostName.isEmpty()){//此处做判断
            throw new UnknownHostException("...");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }
    
    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName){
        if (hostName == null || hostName.isEmpty()){
            throw new IllegalArgumentException("...");//运行时异常
        }
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }
    
    @VisibleForTesting
    protected String generateRandomAlphameric(int length){
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length){
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <='Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <='z';
            if (isDigit || isUppercase || isLowercase){
                randomChars[count] =(char)(randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
