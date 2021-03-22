package com.fullStack.DAO;

import com.fullStack.Entities.Adresse;
import com.fullStack.Entities.Forfatter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForfatterRowMapper implements RowMapper<Forfatter> {

    @Override
    public Forfatter mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Forfatter forfatter = new Forfatter();

        Adresse adresse = new Adresse();
        forfatter.setID(rs.getInt("forfatter_id"));
        forfatter.setNavn(rs.getString("navn"));
        forfatter.setFoedselsAar(rs.getInt("foedsels_aar"));
        forfatter.setAdresse(adresse);
        adresse.setGate(rs.getString("gate"));
        adresse.setPostnr(rs.getInt("postnr"));
        adresse.setID(rs.getInt("adresse_id"));
        adresse.setBy(rs.getString("adresse_by"));
        return forfatter;
    }
}

