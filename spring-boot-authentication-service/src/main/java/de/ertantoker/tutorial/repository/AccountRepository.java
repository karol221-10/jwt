package de.ertantoker.tutorial.repository;

import de.ertantoker.tutorial.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT u FROM Account u WHERE u.username=?1")
    Optional<Account> findOneByUsername(String username);
}
