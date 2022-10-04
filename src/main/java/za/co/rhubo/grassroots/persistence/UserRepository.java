package za.co.rhubo.grassroots.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.rhubo.grassroots.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
