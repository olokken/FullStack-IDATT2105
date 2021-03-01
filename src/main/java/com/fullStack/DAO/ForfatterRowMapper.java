package com.fullStack.DAO;

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
    }
}

        /*forfatter.set
        bok.setNavn(rs.getString("navn"));
        bok.setUtgittAar(rs.getInt("utgittAar"));

        return bok;

=======
        bok.setISBN(rs.getInt("ISBN"));
        bok.setNavn(rs.getString("navn"));
        bok.setUtgittAar(rs.getInt("utgittAar"));

>>>>>>> 312ca76630187e036d86a303d813be370ef7a36d
    }
}*/
