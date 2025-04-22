package tadzhibaeva.spring_security_db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tadzhibaeva.spring_security_db.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.userName= :username")
    User getUserByUserName(@Param("username")String username);
}