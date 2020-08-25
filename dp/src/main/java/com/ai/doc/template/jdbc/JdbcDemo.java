package com.ai.doc.template.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class JdbcDemo {
    public User queryUser(long id){
        Connection conn = null;
        Statement stmt = null;
        try{
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","");
            //2. 创建statement类对象，用来执行SQL语句
            stmt = conn.createStatement();
            //3. resultSet类，用来存放获取的结果集
            String sql = "select * from user where id="+id;
            ResultSet resultSet = stmt.executeQuery(sql);
            
            String eid = null,ename = null, price = null;
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setTelephone(resultSet.getString("telephone"));
                return user;
            }
        }catch (ClassNotFoundException e){
            //TODO log
        }catch (SQLException e){
            //todo log
        }finally {
            if (conn != null){
                try {
                    conn.close();
                }catch (SQLException e){
                    //todo log
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                }catch (SQLException e){
                    //todo log
                }
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
