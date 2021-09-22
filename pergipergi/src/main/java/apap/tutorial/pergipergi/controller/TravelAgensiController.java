package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.service.TravelAgensiService;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.model.TourGuideModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

//@Controller
//public class TravelAgensiController {
//    @Autowired
//    private TravelAgensiService travelAgensiService;
//
//    // Routing URL yang diinginkan
//    @RequestMapping("agensi/add")
//    public String addAgensi (
//        @RequestParam(value = "idAgensi", required = true) String idAgensi,
//        @RequestParam(value = "namaAgensi", required = true) String namaAgensi,
//        @RequestParam(value = "alamat", required = true) String alamat,
//        @RequestParam(value = "noTelepon", required = true) String noTelepon,
//        Model model
//        ){
//
//        // Membuat objek TravelAgensiModel
//        TravelAgensiModel agensi = new TravelAgensiModel(idAgensi, namaAgensi, alamat, noTelepon);
//
//        // Memanggil servis addAgensi
//        travelAgensiService.addAgensi(agensi);
//
//        // Add variabel id agensi ke 'idAgensi' untuk dirender di thymeleaf
//        model.addAttribute("idAgensi", idAgensi);
//
//        // Return view template yang digunakan
//        return "add-agensi";
//    }
//
//    // getAgensiList
//    @RequestMapping("agensi/viewAll")
//    public String listAgensi(Model model) {
//        // Mendapatkan semua TravelAgensiModel
//        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();
//
//        // Memeriksa keberadaan agensi
//        if (listAgensi.size() == 0) {
//            return "null-agensi";
//        }
//
//        // Add variabel semua TravelAgensiModel ke "listAgensi" untuk dirender pada thymeleaf
//        model.addAttribute("listAgensi", listAgensi);
//
//        // Return view template yang diinginkan
//        return "viewall-agensi";
//    }
//
//    // getAgensiByidAgensi
//    @RequestMapping("agensi/view")
//    public String detailAgensi (
//            @RequestParam(value = "idAgensi") String idAgensi,
//            Model model
//    ){
//        // Mendapatkan TravelAgensiModel sesuai dengan idAgensi
//        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
//
//        // Memeriksa keberadaan agensi
//        if (agensi == null) {
//            return "null-agensi";
//        }
//
//        // Add variabel TravelAgensiModel ke "agensi" untuk dirender pada thymeleaf
//        model.addAttribute("agensi", agensi);
//
//        // Return view template yang diinginkan
//        return "view-agensi";
//    }
//
//    // getAgensiByidAgensi dengan menggunakan Path Variable
//    @GetMapping(value = "agensi/view/id-agensi/{idAgensi}")
//    public String detailAgensiPath (
//            @PathVariable(value = "idAgensi") String idAgensi,
//            Model model
//    ) {
//        // Memeriksa keberadaan agensi
//        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
//        if (agensi == null) {
//            return "null-agensi";
//        }
//
//        return detailAgensi(idAgensi, model);
//    }
//
//    private String updateAgensiPage (String idAgensi, String noTelepon, Model model) {
//        // Memanggil servis updateAgensi
//        travelAgensiService.updateNoTeleponByidAgensi(idAgensi, noTelepon);
//
//        // Mendapatkan TravelAgensiModel sesuai dengan idAgensi
//        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
//
//        // Add variavel id agensi ke 'idAgensi' untuk dirender di thymeleaf
//        model.addAttribute("agensi", agensi);
//
//        // Return view template yang digunakan
//        return "update-agensi.html";
//    }
//
//    // updateNoTeleponAgensiByidAgensi dengan menggunakan Path Variable
//    @GetMapping(value = "agensi/update/id-agensi/{idAgensi}/no-telepon/{noTelepon}")
//    public String updateAgensi (
//            @PathVariable(value = "idAgensi", required = true) String idAgensi,
//            @PathVariable(value = "noTelepon", required = true) String noTelepon,
//            Model model
//    ){
//        // Memeriksa keberadaan agensi
//        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
//        if (agensi == null) {
//            return "null-agensi";
//        }
//
//        return updateAgensiPage(idAgensi, noTelepon, model);
//    }
//
//    // deleteAgensi dengan menggunakan Path Variable
//    @GetMapping(value = "agensi/delete/id-agensi/{idAgensi}")
//    public String deleteAgensi (
//            @PathVariable(value = "idAgensi", required = true) String idAgensi,
//            Model model
//    ){
//        // Memeriksa keberadaan agensi
//        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
//        if (agensi == null) {
//            return "null-agensi";
//        }
//
//        // Memanggil servis deleteAgensi
//        travelAgensiService.deleteAgensiByidAgensi(idAgensi);
//
//        // Return view template yang digunakan
//        return "delete-agensi";
//    }
//}

@Controller
public  class TravelAgensiController {

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @GetMapping("/agensi/add")
    public String addAgensiFormPage(Model model){
        model.addAttribute("agensi", new TravelAgensiModel());
        return "form-add-agensi";
    }

    @PostMapping("/agensi/add")
    public String addAgensiSubmitPage(
            @ModelAttribute TravelAgensiModel agensi,
            Model model
    ){
        travelAgensiService.addAgensi(agensi);
        model.addAttribute("noAgensi", agensi.getNoAgensi());
        return "add-agensi";
    }

    @GetMapping("/agensi/viewall")
    public String listAgensi(Model model){
        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();
        model.addAttribute("listAgensi", listAgensi);
        return "viewall-agensi";
    }

    @GetMapping("/agensi/view")
    public String viewDetailAgensiPage(
            @RequestParam(value = "noAgensi") Long noAgensi,
            Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        List<TourGuideModel> listTourGuide = agensi.getListTourGuide();

        model.addAttribute("agensi", agensi);
        model.addAttribute("listTourGuide", listTourGuide);

        return "view-agensi";
    }

    @GetMapping("/agensi/update/{noAgensi}")
    public String updateAgensiFormPage(
            @ModelAttribute Long noAgensi,
            Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        model.addAttribute("agensi", agensi);
        return "form-update-agensi";
    }

    @PostMapping("agensi/update")
    public String updateAgensiSubmitPage(
            @ModelAttribute TravelAgensiModel agensi,
            Model model
    ){
        TravelAgensiModel updatedAgensi = travelAgensiService.updateAgensi(agensi);
        model.addAttribute("noAgensi", updatedAgensi.getNoAgensi());
        return "update-agensi";
    }

    @GetMapping("agensi/delete-agensi/{noAgensi}")
    public String deleteAgensiPage(
            @PathVariable(value = "noAgensi", required = true) Long noAgensi,
            Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        TravelAgensiModel deletedAgensi = travelAgensiService.deleteAgensi(agensi);

        if (deletedAgensi != null) {
            model.addAttribute("agensi", agensi);
            return "delete-agensi";
        }

        return "null-agensi";
    }

}