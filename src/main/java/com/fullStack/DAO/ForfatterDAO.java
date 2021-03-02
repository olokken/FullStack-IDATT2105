package com.fullStack.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fullStack.Entities.Adresse;
import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("READ_Forfatter");
    }

    public Forfatter createForfatter(Forfatter forfatter) {
        //Først legger til adressen i adressetabellen.
        jdbcTemplate.update("INSERT INTO Adresse VALUES(default , ?, ?, ?)", forfatter.getAdresse().getPostnr(), forfatter.getAdresse().getBy(), forfatter.getAdresse().getGate());
        //Deretter legger til forfatteren i forfatterentabellen der jeg bruker methoden(se nedenfor) getAdresseId() som skal returnere id'en til adressen fordi den blir automatisk laget i databsen. (AI)
        jdbcTemplate.update("INSERT INTO Forfatter VALUES (default, ?,  ?, ?)", forfatter.getFoedselsAar(), forfatter.getNavn(), getAdresseId(forfatter.getAdresse()));
        //Skal deretter legge til alle bøkene som kommer med når vi legger til en forfatter. Trenger først forfatterID'en på samme måte som gjort over.
        int forfatterID = getForfatterId(forfatter);
        //Streamer gjennom listen med bøker, og legger først til boka, og deretter en record i koplingstabellen.
        if(forfatter.getBoeker() != null) {
            forfatter.getBoeker().forEach(x -> {
                jdbcTemplate.update("INSERT INTO Bok VALUES (?, ?,  ?)", x.getISBN(), x.getNavn(), x.getUtgittAar());
                jdbcTemplate.update("Insert INTO BokForfatter Values (default, ?, ?)", x.getISBN(), forfatterID);
            });
        }
        forfatter.setID(forfatterID);
        return forfatter;
    }


    public int getAdresseId(Adresse adresse) {
        String query = "SELECT * FROM Adresse WHERE postnr = " + adresse.getPostnr() + " AND adresse_by = " + "'" + adresse.getBy() + "'" + " AND gate = " + "'" + adresse.getGate() + "'";
        ArrayList<Adresse> ad = (ArrayList<Adresse>)jdbcTemplate.query(query, new AdresseRowMapper());
        return ad.get(0).getID();
    }

    public int getForfatterId(Forfatter forfatter) {
        String query = "Select * from Forfatter f where f.foedsels_aar = " + forfatter.getFoedselsAar() + " and  f.navn = " + "'" + forfatter.getNavn() + "'";
        ArrayList<Forfatter> forfattere = (ArrayList<Forfatter>)jdbcTemplate.query(query, new ForfatterOnlyRowMapper());
        return forfattere.get(0).getID();
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
