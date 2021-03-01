package com.fullStack.DAO;

import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository
public class ForfatterDAO {

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
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("Forfatter");
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("READ_Bok");
    }

    public ArrayList<Forfatter> getForfattere() {
        ArrayList<Forfatter> forfattere = (ArrayList<Forfatter>) jdbcTemplate.query("SELECT * FROM Forfatter f join Adresse a on f.adresse_id = a.adresse_id", new ForfatterRowMapper());
        forfattere.forEach(x -> {
            x.setBoeker(getBoeker(x.getID()));
        });
        return forfattere;
    }

    ArrayList<Bok> getBoeker(int forfatter_id) {
        String query = "Select * from Bok b join BokForfatter bf on b.ISBN = bf.ISBN where bf.forfatter_id = " + forfatter_id;
        return (ArrayList<Bok>)jdbcTemplate.query(query, new BokRowMapper());
    }

    public Forfatter finnForfatterVedNavn(String navn) {
        String query = "SELECT * FROM Forfatter f JOIN Adresse a ON f.adresse_id = a.adresse_id WHERE navn = ?";
        Forfatter forfatter = jdbcTemplate.queryForObject(query, new ForfatterRowMapper(), navn);
        forfatter.setBoeker(getBoeker(forfatter.getID()));
        return forfatter;
    }

    public boolean deleteForfatter(int ID) {
        String query = "DELETE FROM Forfatter WHERE forfatter_id = " + ID;
        jdbcTemplate.execute(query);
        return true;
    }

    public Forfatter getForfatter(int ID) {
        String query = "SELECT * FROM Forfatter f JOIN Adresse a ON f.adresse_id = a.adresse_id WHERE forfatter_id = ?";
        Forfatter forfatter = jdbcTemplate.queryForObject(query, new ForfatterRowMapper(), ID);
        forfatter.setBoeker(getBoeker(forfatter.getID()));
        return forfatter;
    }
}
