package com.fullStack.DAO;

import com.fullStack.Entities.Bok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BokDAO {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        final CustomSQLErrorCodeTranslator customSQLErrorCodeTranslator = new CustomSQLErrorCodeTranslator();
        jdbcTemplate.setExceptionTranslator(customSQLErrorCodeTranslator);

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("Bok");
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("READ_Bok");
    }

    public ArrayList<Bok> getBoeker() {
        return (ArrayList<Bok>) jdbcTemplate.query("SELECT * FROM Bok", new BokRowMapper());
    }


    public int createBok(Bok bok) {
        return jdbcTemplate.update("INSERT INTO Bok VALUES (?, ?,  ?)", bok.getISBN(), bok.getNavn(), bok.getUtgittAar());
    }

    public int changeBok(Bok nyInfo, int ISBN) {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("navn", nyInfo.getNavn());
        parameters.put("ISBN", nyInfo.getISBN());
        parameters.put("utgitt_aar", nyInfo.getUtgittAar());

        return simpleJdbcInsert.execute(parameters);
    }


    public Bok getBok(int ISBN) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("ISBN", ISBN);
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM Bok WHERE ISBN = :ISBN", namedParameters, Bok.class);
    }

}
