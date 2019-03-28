package study.recruit.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import study.recruit.common.Fix;
import study.recruit.common.Methods;
import study.recruit.entity.TblUser;
import study.recruit.model.Response;
import study.recruit.repository.UserRepository;

import java.util.Optional;


@Service
public class LoginService implements UserDetailsService {

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TblUser> optional = userRepository.findByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return optional.get();
    }


    public Response register(String username, String password) {
        Methods methods = new Methods();

        Response response = new Response(Response.STATUS_FAIL, Response.MESSAGE_FAIL);

        if (userRepository.findByUsername(username).isPresent()) {
            response.setResponse(Response.STATUS_FAIL, "Username exist");
            return response;
        }

        TblUser tblAccount = new TblUser();
        tblAccount.setUsername(username);
        tblAccount.setPassword(methods.hashPass(password));
        tblAccount.setRole(Fix.ROL_CAN);
        tblAccount.setStatus(1);

        userRepository.save(tblAccount);

        response.setResponse(Response.STATUS_SUCCESS, Response.MESSAGE_SUCCESS);
        return response;
    }
}
