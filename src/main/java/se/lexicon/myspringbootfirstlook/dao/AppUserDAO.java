package se.lexicon.myspringbootfirstlook.dao;

import se.lexicon.myspringbootfirstlook.model.AppUser;
import java.util.Optional;

public interface AppUserDAO {

    Optional<AppUser> findById(int id);

    AppUser save(AppUser appUser);

    void delete(AppUser appUser);



}
