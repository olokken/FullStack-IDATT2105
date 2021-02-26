package com.fullStack.Repository;

import com.fullStack.Entities.Bok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository
public class BokRepo {

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
       return jdbcTemplate.update("INSERT INTO Bok VALUES (?, ?,  ?)", bok.getNavn(), bok.getISBN(), bok.getUtgittAar());
    }

}
