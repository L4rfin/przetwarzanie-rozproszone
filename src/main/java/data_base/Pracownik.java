package data_base;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pracownik")
public class Pracownik {
    @Id
    private int id;
    private String imie;
    private String nazwisko;
    private String notatka;

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNotatka() {
        return notatka;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNotatka(String notatka) {
        this.notatka = notatka;
    }
}
