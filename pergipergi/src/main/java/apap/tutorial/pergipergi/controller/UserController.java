package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.RoleModel;
import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.model.UserModel;
import apap.tutorial.pergipergi.service.UserService;
import apap.tutorial.pergipergi.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    public String addUserFormPage(
            Model model
    ){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.retrieveListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    public String addUserSubmit(
            @ModelAttribute UserModel user,
            Model model
    ){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/update-password")
    public String updatePasswordForm(
            Model model
    ){
        return "form-ubah-password";
    }

//    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    @PostMapping("/update-password")
    public String updatePasswordSubmit(
            @ModelAttribute UserModel user,
            String passwordBaru,
            String passwordKonf,
            Model model
    ){
        UserModel user_byDb = userService.findUserbyUsername(user.getUsername());
        String message = "";

        // Cek password lama di db dan yg dimasukkan user
        if (userService.cekPassword(user.getPassword(), user_byDb.getPassword())) {
            // Cek password baru dg password di field konfirmasi
            if (passwordBaru.equals(passwordKonf)) {
                userService.updatePassword(user_byDb, passwordBaru);
                userService.addUser(user_byDb);
                message = "Password berhasil diubah!";
            } else {
                message = "Password baru yang Anda masukkan berbeda!";
            }
        } else {
            message = "Password lama Anda salah!";
        }

        model.addAttribute("message", message);
        return "form-ubah-password";
    }

    @GetMapping("/viewall")
    public String viewAllUser(
            Model model
    ){
        model.addAttribute("listUser", userService.retrieveListUser());
        return "view-all-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(
            @PathVariable(value = "username", required = true) String username,
            Model model
    ){
        UserModel deletedUser = userService.deleteUser(username);
        model.addAttribute("listUser", userService.retrieveListUser());
        return "view-all-user";
    }

}
