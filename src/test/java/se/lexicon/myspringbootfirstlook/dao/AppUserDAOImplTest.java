package se.lexicon.myspringbootfirstlook.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myspringbootfirstlook.model.AppUser;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestEntityManager
@DirtiesContext
@Transactional
class AppUserDAOImplTest {

    @Autowired
    AppUserDAO appUserDAO;

    @Autowired
    TestEntityManager entityManager;

    // Arrange/Act/Assert
    // Given/When/Then

    @Test
    void save() {

        AppUser appUser = new AppUser("TestUSer2" , "Testfirst2", "Testlast2", LocalDate.parse("2000-02-04"),"221212");
        appUserDAO.save(appUser);
        assertNotEquals(0,appUser.getUserId());
    }

    @Test
    void findById() {

        AppUser appUser = new AppUser("kalTes", "Test", "Testsson", LocalDate.parse("2000-12-12"), "qwerty");

        Integer id = entityManager.persistAndGetId(appUser, Integer.class);
        entityManager.clear();

        Optional<AppUser> appUserDaoById = appUserDAO.findById(id);
        assertTrue(appUserDaoById.isPresent());
        Assertions.assertEquals(id, appUserDaoById.get().getUserId());
    }

    @Test
    void delete() {



    }
}