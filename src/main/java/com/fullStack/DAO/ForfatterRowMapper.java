package com.fullStack.DAO;

<<<<<<< HEAD
=======
import com.fullStack.Entities.Adresse;
import com.fullStack.Entities.Bok;
>>>>>>> 096f807679dce6bc094678197a41dee97fb44ff4
import com.fullStack.Entities.Forfatter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForfatterRowMapper implements RowMapper<Forfatter> {

    @Override
    public Forfatter mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Forfatter forfatter = new Forfatter();
<<<<<<< HEAD
        return forfatter;
=======
        Adresse adresse = new Adresse();
        forfatter.setID(rs.getInt("forfatter_id"));
        forfatter.setNavn(rs.getString("navn"));
        forfatter.setFoedselsAar(rs.getInt("foedsels_aar"));
        adresse.setBy(rs.getString("by"));
        adresse.setGate(rs.getString("gate"));
        adresse.setPostnr(rs.getInt("postnr"));
        forfatter.setAdresse(adresse);
        return forfatter; 

>>>>>>> 096f807679dce6bc094678197a41dee97fb44ff4
    }
}

