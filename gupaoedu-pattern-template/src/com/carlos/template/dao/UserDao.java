package com.carlos.template.dao;

import com.carlos.template.JDBCTemplate;
import com.carlos.template.RowMapper;
import com.carlos.template.entity.User;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public class UserDao {

    private JDBCTemplate jdbcTemplate = new JDBCTemplate(null);

    public List<?> executeQuery() throws Exception {
        String sql = "select * from user";
        return jdbcTemplate.executeQuery(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int rowNum) throws Exception {
                User user = new User();
                user.setAge(resultSet.getInt("age"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                return user;
            }
        }, null);

    }
}
