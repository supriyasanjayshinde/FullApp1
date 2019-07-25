package com.kgisl.springjson.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.kgisl.springjson.model.Contact;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ContactDAOImpl implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void saveOrUpdate(Contact contact) {

    }

    public void delete(int contactId) {

    }

    public Contact get(int contactId) {
        return null;
    }

    public List<Contact> list()
    {
            String sql = "SELECT * FROM contact";
            List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>()
            {
                            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException 
                            {
                                 Contact aContact = new Contact();
                                    aContact.setId(rs.getInt("contact_id"));
                                    aContact.setName(rs.getString("name"));
                                    aContact.setEmail(rs.getString("email"));
                                    aContact.setAddress(rs.getString("address"));
                                    aContact.setTelephone(rs.getString("telephone"));
                                return aContact;
                            }
 
                });
 
    return listContact;
    }
}