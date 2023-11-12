package data_base;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wyniki")
public class Wynik {

    @Id
    private int id_pracownika;
    private int ilosc_zgloszen;
    private int staz_pracy;

    public int getId_pracownika() {
        return id_pracownika;
    }

    public int getIlosc_zgloszen() {
        return ilosc_zgloszen;
    }

    public int getStaz_pracy() {
        return staz_pracy;
    }
}
