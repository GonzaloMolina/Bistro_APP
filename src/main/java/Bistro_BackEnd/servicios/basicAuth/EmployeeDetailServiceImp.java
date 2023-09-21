package Bistro_BackEnd.servicios.basicAuth;

import Bistro_BackEnd.dao.empleado.MozoDao;
import Bistro_BackEnd.model.empleado.Mozo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmployeeDetailServiceImp implements UserDetailsService {

    @Autowired
    private MozoDao userRepository;

    @Override
    public EmployeeDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Mozo user = userRepository.getUserByUsername(username);

        if (user == null) { throw new UsernameNotFoundException("Could not find user"); }
        return new EmployeeDetails(user);
    }
}

