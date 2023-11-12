import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import data_base.Pracownik;
import data_base.Wynik;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {

    }
    @Provides
    @Singleton
    public SessionFactory getSessionFactory(){
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();
        try {
            var sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(Pracownik.class)
                            .addAnnotatedClass(Wynik.class)
                            .buildMetadata()
                            .buildSessionFactory();
            return sessionFactory;
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }

}
