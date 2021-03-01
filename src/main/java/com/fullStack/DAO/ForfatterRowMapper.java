package com.fullStack.DAO;

import com.fullStack.Entities.Bok;
import com.fullStack.Entities.Forfatter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForfatterRowMapper implements RowMapper<Forfatter> {

    @Override
    public Forfatter mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Forfatter forfatter = new Forfatter();

<<<<<<< HEAD
        forfatter.setNavn(rs.getString("navn"));
        forfatter.setID(rs.getInt("id"));
        forfatter.setFoedselsAar(rs.getInt("foedselsAar"));
        return forfatter;
=======
        /*forfatter.set
        bok.setNavn(rs.getString("navn"));
        bok.setUtgittAar(rs.getInt("utgittAar"));

        return bok;*/
>>>>>>> 88eb6503f7bc3283e2701f86e5a6bf2755c74ef7

    }
}
