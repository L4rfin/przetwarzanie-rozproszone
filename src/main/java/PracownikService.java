import com.google.inject.Inject;
import data_base.Pracownik;
import data_base.Wynik;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class PracownikService {
    private final SessionFactory sessionFactory;
    @Inject
    public PracownikService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public ArrayList<Pracownik> readAll(){
        ArrayList<Pracownik> list = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Pracownik ", Pracownik.class)
                    .getResultList().forEach(person -> list.add(person));
        });
        list.forEach(pracownik -> System.out.println("id: "+pracownik.getId()+", imie "+pracownik.getImie() +", nazwisko "+pracownik.getNazwisko()+"\n notatka"+pracownik.getNotatka() ));
        return list;
    }

    public ArrayList<Pracownik> readWhereId(int sabmit_id_pracwonika) {
        ArrayList<Pracownik> list = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Pracownik where id =" + sabmit_id_pracwonika, Pracownik.class)
                    .getResultList().
                    forEach(wynik -> list.add(wynik));
        });
        list.forEach(pracownik -> System.out.println("id: "+pracownik.getId()+", imie "+pracownik.getImie() +", nazwisko "+pracownik.getNazwisko()+"\n notatka"+pracownik.getNotatka() ));
        return list;
    }

    public ArrayList<Pracownik> readWhereImie(String sabmit_imie_pracwonika) {
        ArrayList<Pracownik> list = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Pracownik where imie like \"" +sabmit_imie_pracwonika+"\"" , Pracownik.class)
                    .getResultList().
                    forEach(wynik -> list.add(wynik));
        });
        list.forEach(pracownik -> System.out.println("id: "+pracownik.getId()+", imie "+pracownik.getImie() +", nazwisko "+pracownik.getNazwisko()+"\n notatka "+pracownik.getNotatka() ));
        return list;
    }
    public ArrayList<Pracownik> readWhereNazwisko(String sabmit_nazwisko_pracwonika) {
        ArrayList<Pracownik> list = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Pracownik where nazwisko like \"" +sabmit_nazwisko_pracwonika+"\"" , Pracownik.class)
                    .getResultList().
                    forEach(wynik -> list.add(wynik));
        });
        list.forEach(pracownik -> System.out.println("id: "+pracownik.getId()+", imie "+pracownik.getImie() +", nazwisko "+pracownik.getNazwisko()+"\n notatka "+pracownik.getNotatka() ));
        return list;
    }

    public Boolean addPracownik(Pracownik newPracownik){
        sessionFactory.inTransaction(session -> session.saveOrUpdate(newPracownik));
        return true;
    }
    public Boolean updatePracownik(Pracownik newPracownik){
        if (newPracownik.getId()>0) {

        sessionFactory.inTransaction(session -> session.saveOrUpdate(newPracownik));
        return true;
        }
    return false;
    }

    public boolean deletePracownik(Pracownik outPracownik){

        if (outPracownik.getId()<0){
            return false;
        }
        sessionFactory.inTransaction(session -> session.delete(outPracownik));
        return true;
    }

}
