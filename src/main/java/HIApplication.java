import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import data_base.Pracownik;

@Singleton
public class HIApplication /*extends Application*/ {


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ApplicationModule());
        WynikService wynikService = injector.getInstance(WynikService.class);
        PracownikService pracownikService = injector.getInstance(PracownikService.class);
//        pracownikService.readAll();
//        wynikService.readAll();
//        wynikService.readWhereId(1);
//        pracownikService.readWhereId(1);
        pracownikService.readWhereImie("Pączek");
        pracownikService.readWhereNazwisko("Adam");
        Pracownik pracownik = new Pracownik();
        pracownik.setId(13);
        pracownik.setImie("Marek");
        pracownik.setNazwisko("Michał");
        pracownik.setNotatka("bbbbbbbb");
//        pracownikService.addPracownik(pracownik);
//        System.out.println(pracownikService.updatePracownik(pracownik));
        pracownikService.deletePracownik(pracownik);
    }


}
