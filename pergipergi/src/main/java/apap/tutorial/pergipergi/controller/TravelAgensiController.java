package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.service.TravelAgensiService;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class TravelAgensiController {
    @Autowired
    private TravelAgensiService travelAgensiService;

    // Routing URL yang diinginkan
    @RequestMapping("agensi/add")
    public String addAgensi (
        @RequestParam(value = "idAgensi", required = true) String idAgensi,
        @RequestParam(value = "namaAgensi", required = true) String namaAgensi,
        @RequestParam(value = "alamat", required = true) String alamat,
        @RequestParam(value = "noTelepon", required = true) String noTelepon,
        Model model
        ){

        // Membuat objek TravelAgensiModel
        TravelAgensiModel agensi = new TravelAgensiModel(idAgensi, namaAgensi, alamat, noTelepon);

        // Memanggil servis addAgensi
        travelAgensiService.addAgensi(agensi);

        // Add variabel id agensi ke 'idAgensi' untuk dirender di thymeleaf
        model.addAttribute("idAgensi", idAgensi);

        // Return view template yang digunakan
        return "add-agensi";
    }

    // getAgensiList
    @RequestMapping("agensi/viewAll")
    public String listAgensi(Model model) {
        // Mendapatkan semua TravelAgensiModel
        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();

        // Memeriksa keberadaan agensi
        if (listAgensi.size() == 0) {
            return "null-agensi";
        }

        // Add variabel semua TravelAgensiModel ke "listAgensi" untuk dirender pada thymeleaf
        model.addAttribute("listAgensi", listAgensi);

        // Return view template yang diinginkan
        return "viewall-agensi";
    }

    // getAgensiByidAgensi
    @RequestMapping("agensi/view")
    public String detailAgensi (
            @RequestParam(value = "idAgensi") String idAgensi,
            Model model
    ){
        // Mendapatkan TravelAgensiModel sesuai dengan idAgensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);

        // Memeriksa keberadaan agensi
        if (agensi == null) {
            return "null-agensi";
        }

        // Add variabel TravelAgensiModel ke "agensi" untuk dirender pada thymeleaf
        model.addAttribute("agensi", agensi);

        // Return view template yang diinginkan
        return "view-agensi";
    }

    // getAgensiByidAgensi dengan menggunakan Path Variable
    @GetMapping(value = "agensi/view/id-agensi/{idAgensi}")
    public String detailAgensiPath (
            @PathVariable(value = "idAgensi") String idAgensi,
            Model model
    ) {
        // Memeriksa keberadaan agensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
        if (agensi == null) {
            return "null-agensi";
        }

        return detailAgensi(idAgensi, model);
    }

    private String updateAgensiPage (String idAgensi, String noTelepon, Model model) {
        // Memanggil servis updateAgensi
        travelAgensiService.updateNoTeleponByidAgensi(idAgensi, noTelepon);

        // Mendapatkan TravelAgensiModel sesuai dengan idAgensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);

        // Add variavel id agensi ke 'idAgensi' untuk dirender di thymeleaf
        model.addAttribute("agensi", agensi);

        // Return view template yang digunakan
        return "update-agensi.html";
    }

    // updateNoTeleponAgensiByidAgensi dengan menggunakan Path Variable
    @GetMapping(value = "agensi/update/id-agensi/{idAgensi}/no-telepon/{noTelepon}")
    public String updateAgensi (
            @PathVariable(value = "idAgensi", required = true) String idAgensi,
            @PathVariable(value = "noTelepon", required = true) String noTelepon,
            Model model
    ){
        // Memeriksa keberadaan agensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
        if (agensi == null) {
            return "null-agensi";
        }

        return updateAgensiPage(idAgensi, noTelepon, model);
    }

    // deleteAgensi dengan menggunakan Path Variable
    @GetMapping(value = "agensi/delete/id-agensi/{idAgensi}")
    public String deleteAgensi (
            @PathVariable(value = "idAgensi", required = true) String idAgensi,
            Model model
    ){
        // Memeriksa keberadaan agensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);
        if (agensi == null) {
            return "null-agensi";
        }

        // Memanggil servis deleteAgensi
        travelAgensiService.deleteAgensiByidAgensi(idAgensi);

        // Return view template yang digunakan
        return "delete-agensi";
    }
}
