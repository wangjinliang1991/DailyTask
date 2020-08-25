package com.ai.doc.template.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class JdbcTemplateDemo {
    private JdbcTemplate jdbcTemplate;
    public User queryUser(long id){
        String sql = "select * from user where id="+id;
        return jdbcTemplate.query(sql,new UserRowMapper().get(0));
    }


    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setTelephone(rs.getString("telephone"));
            return user;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
