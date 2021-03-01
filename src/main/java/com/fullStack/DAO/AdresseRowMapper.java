package com.fullStack.DAO;

import com.fullStack.Entities.Adresse;
import com.fullStack.Entities.Bok;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseRowMapper implements RowMapper<Adresse> {
    @Override
    public Adresse mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Adresse adresse = new Adresse();
        adresse.setID(rs.getInt("adresse_id"));
        adresse.setPostnr(rs.getInt("postnr"));
        adresse.setGate(rs.getString("gate"));
        adresse.setBy(rs.getString("by"));
        return adresse;
    }
}
