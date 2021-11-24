package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel findUserbyUsername(String username);
    boolean cekPassword(String passwordBaru, String passwordLama);
    void updatePassword(UserModel user, String passwordBaru);
    List<UserModel> retrieveListUser();
    UserModel deleteUser(String username);

}
