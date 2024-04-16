package Zoul.lalaina.BackEnd.service;

import Zoul.lalaina.BackEnd.dto.LoginDto;
import Zoul.lalaina.BackEnd.dto.UserDto;
import Zoul.lalaina.BackEnd.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String addUser(UserDto userDto);

    LoginResponse loginUser(LoginDto loginDto);
    LoginResponse loginUser();
    LoginResponse logoutUser();

}
