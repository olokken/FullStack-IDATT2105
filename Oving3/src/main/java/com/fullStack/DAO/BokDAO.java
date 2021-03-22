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


    public void createBok(Bok bok) {
         jdbcTemplate.update("INSERT INTO Bok VALUES (?, ?,  ?)", bok.getISBN(), bok.getNavn(), bok.getUtgittAar());
    }

    public int changeBok(Bok nyInfo, int ISBN) {
        return jdbcTemplate.update("UPDATE Bok SET ISBN = ?, navn = ?, utgitt_aar = ? WHERE ISBN = " + ISBN, nyInfo.getISBN(), nyInfo.getNavn(), nyInfo.getUtgittAar());
    }


    public Bok getBok(int ISBN) {
        String query = "SELECT * FROM Bok WHERE ISBN = ?";
        Bok bok = jdbcTemplate.queryForObject(query, new BokRowMapper(), ISBN);
        return bok;
    }

    public boolean deleteBok(int ISBN) {
        String query = "DELETE FROM Bok WHERE ISBN = " + ISBN;
        jdbcTemplate.execute(query);
        return true;
    }

    public Bok finnBokVedNavn(String navn) {
        String query = "SELECT * FROM Bok WHERE navn = ?";
        Bok bok = jdbcTemplate.queryForObject(query, new BokRowMapper(), navn);
        return bok;
    }

    public Bok tomBok() {
        return new Bok();
    }

}
