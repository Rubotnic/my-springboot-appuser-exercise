package se.lexicon.myspringbootfirstlook;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.myspringbootfirstlook.model.AppUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;


@Transactional
@Component
public class MyCommandLineRunner implements CommandLineRunner {

@PersistenceContext
EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {


        AppUser rager = new AppUser("kalTes", "Test", "Testsson", LocalDate.parse("2000-12-12"),"qwerty");
        entityManager.persist(rager);
        System.out.println(rager);

        AppUser found = entityManager.find(AppUser.class, 1);
        System.out.println(found);


        AppUser test2 = new AppUser("kalTes", "Test2", "Testsson2", LocalDate.parse("2000-11-11"), "12345");
        entityManager.persist(test2);
        System.out.println(test2);

        AppUser found2 = entityManager.find(AppUser.class, 2);
        System.out.println(found2);



    }
}
