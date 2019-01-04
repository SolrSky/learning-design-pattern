package com.carlos.template;

import java.sql.ResultSet;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public interface RowMapper<T> {
    public T mapRow(ResultSet resultSet, int rowNum) throws Exception;
}
