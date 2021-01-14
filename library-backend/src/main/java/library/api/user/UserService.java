package library.api.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Nie znaleziono użytkownika o podanym loginie")
        );

        return user;
    }

    public User findCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = findUserByUsername(username);

        return user;
    }

    public UserDTO getCurrentUser() {
        User user = findCurrentUser();
        UserDTO userDTO = new UserDTO(user);

        return userDTO;
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        users.forEach(user -> userDTOs.add(new UserDTO(user)));

        return userDTOs;
    }

}
