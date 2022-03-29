package com.decryptor.repository;

import com.decryptor.dto.GetHistoryResponse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlRepository implements DataBaseInterface{

    private final JdbcTemplate jdbcTemplate;

    public MysqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(String request) {
      var query = "INSERT INTO RequestHistory(date,time,request) VALUES(date(curdate()), time(now()), '" + request + "');";
      var keyHolder = new GeneratedKeyHolder();
    }

    @Override
    public GetHistoryResponse getHistory() {
        return (GetHistoryResponse) jdbcTemplate.query("SELECT * FROM Decryptor.RequestHistory", new BeanPropertyRowMapper(RepositoryObject.class));
    }
}
