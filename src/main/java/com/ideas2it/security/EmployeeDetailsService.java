package com.ideas2it.security;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService  implements UserDetailsService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Employee employee = employeeDao.findByName(name);
        if(employee == null) {
            throw new UsernameNotFoundException("Employee Not Found");
        }
        return new EmployeeUserDetails(employee) ;
    }
}
