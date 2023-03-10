package es.nhs.alquilerhardware.repository.repositorySecurity;

import es.nhs.alquilerhardware.models.modelsSecurity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 17/02/2023
 */
public interface IUserRepository extends JpaRepository<User, Integer>
{

    User findByUserName(String username);

    User findByEmail(String email);

}
