package com.fullStack.DAO;

import com.fullStack.Entities.Bok;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BokRowMapper implements RowMapper<Bok> {

    @Override
    public Bok mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Bok bok = new Bok();
        bok.setISBN(rs.getInt("ISBN"));
        bok.setNavn(rs.getString("navn"));
        bok.setUtgittAar(rs.getInt("utgitt_aar"));
        return bok;
    }
}
