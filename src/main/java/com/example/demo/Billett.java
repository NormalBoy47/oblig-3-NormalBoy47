package com.example.demo;

public class Billett {
    //Attributter for hver enkelt verdi
    private int Id;
    private String Film;
    private int Antall;
    private String ForNavn;
    private String EtterNavn;
    private int Nummer;
    private String Epost;

    public Billett(int Id, String Film, int Antall, String ForNavn, String EtterNavn, int Nummer, String Epost) {
        this.Id = Id;
        this.Film = Film;
        this.Antall = Antall;
        this.ForNavn = ForNavn;
        this.EtterNavn = EtterNavn;
        this.Nummer = Nummer;
        this.Epost = Epost;
    }
    //get set metoder for alle verdiene
    public Billett() {
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
    public String getFilm() {
        return Film;
    }

    public void setFilm(String film) {
        Film = film;
    }

    public int getAntall() {
        return Antall;
    }

    public void setAntall(int antall) {
        Antall = antall;
    }

    public String getForNavn() {
        return ForNavn;
    }

    public void setForNavn(String forNavn) {
        ForNavn = forNavn;
    }

    public String getEtterNavn() {
        return EtterNavn;
    }

    public void setEtterNavn(String etterNavn) {
        EtterNavn = etterNavn;
    }

    public int getNummer() {
        return Nummer;
    }

    public void setNummer(int nummer) {
        Nummer = nummer;
    }

    public String getEpost() {
        return Epost;
    }

    public void setEpost(String epost) {
        Epost = epost;
    }

}
