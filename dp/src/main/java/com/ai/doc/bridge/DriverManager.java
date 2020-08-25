package com.ai.doc.bridge;

import sun.reflect.Reflection;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverInfo;
import java.sql.SQLException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public class DriverManager {
    private final static CopyOnWriteArrayList<DriverInfo> registeredDrivers = new CopyOnWriteArrayList<>();
    //...
    static {
        loadInitialDrivers();
        println("JDBC DriverManager initialized");
    }
    //...
    public static synchronized void registerDriver(java.sql.Driver driver, DriverAction da) throws SQLException {
        if(driver != null) {
            registeredDrivers.addIfAbsent(new DriverInfo(driver, da));
        } else {
            throw new NullPointerException();
        }
    }

    public static Connection getConnection(String url,String user, String password) throws SQLException {
        java.util.Properties info = new java.util.Properties();
        if (user != null) {
            info.put("user", user);
        }
        if (password != null) {
            info.put("password", password);
        }
        return (getConnection(url, info, Reflection.getCallerClass()));
    }     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
