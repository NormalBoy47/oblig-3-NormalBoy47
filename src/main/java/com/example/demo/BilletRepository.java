package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilletRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillet(Billett billett) {
        String sql = "INSERT INTO Billett (Film, Antall, ForNavn, EtterNavn, Nummer, Epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, billett.getFilm(), billett.getAntall(), billett.getForNavn(), billett.getEtterNavn(), billett.getNummer(), billett.getEpost() );
    }

    public List<Billett> alleBilletter() {
         String sql = "SELECT * FROM Billett";
        List<Billett> alleBilletter = db.query(sql,new BeanPropertyRowMapper(Billett.class));
        return alleBilletter;
    }

    public void slettAlleBilletter () {
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }
}