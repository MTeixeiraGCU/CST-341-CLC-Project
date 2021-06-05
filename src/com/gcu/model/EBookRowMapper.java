package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This class is designed to allow Spring JDBC to automatically map `books` table database columns onto a EBook object.
 *
 */
public class EBookRowMapper implements RowMapper<EBook> {

	@Override
	public EBook mapRow(ResultSet result, int row) throws SQLException {
		EBook eBook = new EBook();
		eBook.setTitle(result.getString("TITLE"));
		eBook.setAuthor(result.getString("AUTHOR"));
		eBook.setPublisher(result.getString("PUBLISHER"));
		eBook.setPublicationDate(result.getDate("PUBLICATION_DATE"));
		eBook.setIsbn(result.getString("ISBN"));
		eBook.setImage(result.getString("IMAGE"));
		return eBook;
	}

}
