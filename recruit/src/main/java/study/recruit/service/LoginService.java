package study.recruit.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import study.recruit.entity.TblUser;
import study.recruit.repository.UserRepository;

import java.util.Optional;


@Service
public class LoginService implements UserDetailsService {

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TblUser findByUsername(String username) {
        Optional<TblUser> optional = userRepository.findByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return optional.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TblUser> optional = userRepository.findByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return optional.get();
    }
}
