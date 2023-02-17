package es.nhs.alquilerhardware.security.users;

import es.nhs.alquilerhardware.models.modelsSecurity.Role;
import es.nhs.alquilerhardware.models.modelsSecurity.User;
import es.nhs.alquilerhardware.repository.repositorySecurity.IRoleSecurity;
import es.nhs.alquilerhardware.repository.repositorySecurity.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 17/02/2023
 */
@Service
public class UserService
{

    private IUserRepository userRepository;

    private IRoleSecurity roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(
            IUserRepository userRepository,
            IRoleSecurity roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder
    )
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByUserName(String username)
    {
        return userRepository.findByUserName(username);
    }

    public User findUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

}
