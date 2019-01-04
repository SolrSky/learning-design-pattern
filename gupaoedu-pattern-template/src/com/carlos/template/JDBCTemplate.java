package com.carlos.template;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public class JDBCTemplate {

    private DataSource dataSource;

    public JDBCTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) throws Exception{
        //1.获取连接
        Connection conn = this.getConnection();
        //2.创建语句集
        PreparedStatement preparedStatement = this.createPreparedStatement(conn, sql);
        //3.执行语句集，并获得结果集
        ResultSet resultSet = this.executeQuery(preparedStatement, values);
        //4.解析结果集
        List<?> result = this.parseResultSet(resultSet, rowMapper);
        //5.关闭结果集
        this.closeResultSet(resultSet);
        //6.关闭语句集
        this.closeStatement(preparedStatement);
        //7.关闭连接
        this.closeConnection(conn);
        return result;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    private PreparedStatement createPreparedStatement(Connection conn,String sql) throws  Exception{
        return  conn.prepareStatement(sql);
    }


    private ResultSet executeQuery(PreparedStatement pstmt,Object [] values) throws  Exception{
        for (int i = 0; i <values.length; i ++){
            pstmt.setObject(i,values[i]);
        }
        return  pstmt.executeQuery();
    }


    private void closeStatement(Statement stmt) throws  Exception{
        stmt.close();
    }

    private void closeResultSet(ResultSet rs) throws  Exception{
        rs.close();
    }

    private void closeConnection(Connection conn) throws  Exception{
        //通常把它放到连接池回收
    }



    private List<?> parseResultSet(ResultSet rs,RowMapper rowMapper) throws  Exception{
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum ++));
        }
        return result;
    }


    private Object proccessResultSet(ResultSet resultSet, RowMapper<?> rowMapper, int rowNum) throws Exception{
        return  rowMapper.mapRow(resultSet, rowNum);
    }

}
