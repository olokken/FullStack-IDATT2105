package com.fullStack.DAO;

import com.fullStack.Entities.Adresse;
import com.fullStack.Entities.Forfatter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForfatterOnlyRowMapper implements RowMapper<Forfatter> {

    @Override
    public Forfatter mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Forfatter forfatter = new Forfatter();
        forfatter.setID(rs.getInt("forfatter_id"));
        forfatter.setNavn(rs.getString("navn"));
        forfatter.setFoedselsAar(rs.getInt("foedsels_aar"));
        return forfatter;
    }
}

