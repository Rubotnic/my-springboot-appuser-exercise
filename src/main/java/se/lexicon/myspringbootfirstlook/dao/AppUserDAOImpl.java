package se.lexicon.myspringbootfirstlook.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myspringbootfirstlook.model.AppUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Transactional
@Repository
public class AppUserDAOImpl implements AppUserDAO{
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public Optional<AppUser> findById(int id) {
        if (id <= 0) throw new IllegalArgumentException("Invalid ID");
    AppUser appUser = entityManager.find(AppUser.class, id);
        return Optional.ofNullable(appUser);
    }

    @Transactional
    @Override
    public AppUser save(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("AppUser was Null!");
        entityManager.persist(appUser);
        return appUser;
    }

    @Transactional
    @Override
    public void delete(AppUser appUser) {
        findById(appUser.getUserId()).orElseThrow(() -> new IllegalArgumentException("data not found"));
        entityManager.remove(appUser);
    }
}
