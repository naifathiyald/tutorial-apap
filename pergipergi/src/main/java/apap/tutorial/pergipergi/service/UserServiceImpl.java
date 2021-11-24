package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.UserModel;
import apap.tutorial.pergipergi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordHash = passwordEncoder.encode(password);
        return passwordHash;
    }

    @Override
    public UserModel findUserbyUsername(String username) {
        return userDb.findByUsername(username);
    }

    @Override
    public boolean cekPassword(String passwordBaru, String passwordLama) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean flag = passwordEncoder.matches(passwordBaru, passwordLama);
        return flag;
    }

    @Override
    public void updatePassword(UserModel user, String passwordBaru) {
        user.setPassword(passwordBaru);
    }

    @Override
    public List<UserModel> retrieveListUser() {
        return userDb.findAll();
    }

    @Override
    public UserModel deleteUser(String username) {
        UserModel user = userDb.findByUsername(username);
        userDb.delete(user);
        return user;
    }
}
