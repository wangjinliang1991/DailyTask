package com.ai.doc.bridge;

import java.sql.SQLException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public class Driver extends NonRegisteringDriver implements java.sql.Driver {
    static {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
        }catch (SQLException e){
            throw new RuntimeException("can't register driver!");
        }
    }
    
    // construct a new driver and register it with DriverManager
    public Driver() throws SQLException{
        // Require for Class.forName().newInstance()
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
