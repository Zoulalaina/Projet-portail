package Zoul.lalaina.BackEnd.service.impl;

import Zoul.lalaina.BackEnd.dto.LoginDto;
import Zoul.lalaina.BackEnd.dto.UserDto;
import Zoul.lalaina.BackEnd.model.User;
import Zoul.lalaina.BackEnd.repository.UserRepository;
import Zoul.lalaina.BackEnd.response.LoginResponse;
import Zoul.lalaina.BackEnd.service.UserService;
import ch.qos.logback.classic.encoder.JsonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    static int islogged=0;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserName(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);



        return user.getUserName();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg="";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if(user1 != null){
            String password = loginDto.getPassword();
            String encodePassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if(isPwdRight){
                Optional<User> user = userRepository.findByEmailAndPassword(loginDto.getEmail(), encodePassword);
                if(user.isPresent()){
                    islogged++;
                    return new LoginResponse("login success",true);


                }else {
                    return new LoginResponse("login failed",false);

                }
            }else {
                return new LoginResponse("password not math", false); 

            }
        }else {
            return new LoginResponse("Email not exist", false);
        }
    }

    @Override
    public LoginResponse loginUser() {
        if(islogged==1){
            return new LoginResponse("login success",true);

        }else {
            return new LoginResponse("Email not exist", false);
        }

    }

    @Override
    public LoginResponse logoutUser() {
        if(islogged==1){
            islogged--;
            if (islogged==0){
                return new LoginResponse("logout user",true);
            }else {
                return new LoginResponse("connected", false);
            }
        }
        return new LoginResponse("no",false);



    }

}
