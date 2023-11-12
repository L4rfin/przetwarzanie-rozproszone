import com.google.inject.Inject;
import data_base.Pracownik;
import data_base.Wynik;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class WynikService {
    private final SessionFactory sessionFactory;
    @Inject
    public WynikService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public ArrayList<Wynik> readAll(){
        ArrayList<Wynik> list = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Wynik", Wynik.class)
                    .getResultList().forEach(Wynik -> list.add(Wynik));
        });
        System.out.println("wyszystkie wyszukania");
        list.forEach(wynik -> System.out.println("id pracownika "+wynik.getId_pracownika()+", ilość zgłoszeń "+wynik.getIlosc_zgloszen()+", staż pracy "+wynik.getStaz_pracy() +" lata\n" ));
        return list;
    }
    public ArrayList<Wynik> readWhereId(int sabmit_id_pracwonika){
        ArrayList<Wynik> list = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Wynik where id_pracownika =" + sabmit_id_pracwonika,Wynik.class)
                    .getResultList().
                    forEach(wynik -> list.add(wynik));
        });
        System.out.println("statystyki pracownika o id: "+sabmit_id_pracwonika);
        list.forEach(wynik -> System.out.println("ilość zgłoszeń "+wynik.getIlosc_zgloszen()+", staż pracy "+wynik.getStaz_pracy() +" lata\n" ));
        return list;
    }



}
