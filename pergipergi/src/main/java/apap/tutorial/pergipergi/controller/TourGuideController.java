package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.service.TourGuideService;
import apap.tutorial.pergipergi.service.TravelAgensiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TourGuideController {

//    @Qualifier("TourGuideServiceImpl")
    @Autowired
    private TourGuideService tourGuideService;

//    @Qualifier("TravelAgensiServiceImp")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @GetMapping("/tour-guide/add/{noAgensi}")
    public String addTourGuideFormPage(@PathVariable Long noAgensi, Model model){
        TourGuideModel guide = new TourGuideModel();
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        guide.setAgensi(agensi);
        model.addAttribute("guide", guide);
        return "form-add-tour-guide";
    }

    @PostMapping("/tour-guide/add")
    public String addTourGuideSubmitPage(
            @ModelAttribute TourGuideModel tourGuide,
            Model model
    ){
        tourGuideService.addTourGuide(tourGuide);
        model.addAttribute("noTourGuide", tourGuide.getNoTourGuide());
        return "add-tour-guide";
    }

    @GetMapping("/tour-guide/update/{noTourGuide}")
    public String updateTourGuideFormPage(
            @PathVariable(value = "noTourGuide", required = true) Long noTourGuide,
            Model model
    ){
        TourGuideModel guide = tourGuideService.getGuideByNoTourGuide(noTourGuide);

        model.addAttribute("guide", guide);
        model.addAttribute("noTourGuide", noTourGuide);
        return "form-update-tour-guide";
    }

    @PostMapping("tour-guide/update")
    public String updateTourGuideSubmitPage(
            @ModelAttribute TourGuideModel guide,
            Model model
    ){

        TourGuideModel updatedGuide = tourGuideService.updateTourGuide(guide);

        if (updatedGuide != null) {
            model.addAttribute("noTourGuide", updatedGuide.getNoTourGuide());
            model.addAttribute("noAgensi", updatedGuide.getAgensi().getNoAgensi());
            return "update-tour-guide";
        }
        return "null-agensi";
    }

//    @GetMapping("tour-guide/delete/{noTourGuide}") // deleteTourGuide buatan ku
//    public String deleteTourGuidePage(
//            @PathVariable(value = "noTourGuide", required = true) Long noTourGuide,
//            Model model
//    ){
//        TourGuideModel tourGuide = tourGuideService.getGuideByNoTourGuide(noTourGuide);
//        TravelAgensiModel agensi = tourGuide.getAgensi();
//
//        TourGuideModel deletedGuide = tourGuideService.deleteTourGuide(tourGuide);
//
//        if (deletedGuide != null) {
//            model.addAttribute("tourGuide", tourGuide);
//            model.addAttribute("agensi", agensi);
//            return "delete-tour-guide";
//        }
//
//        return "null-agensi";
//    }

    @PostMapping("/tour-guide/delete")
    public String deleteTourGuideSubmit(
            @ModelAttribute TravelAgensiModel agensi,
            Model model
    ){
        if (travelAgensiService.isClosed(agensi.getWaktuBuka(), agensi.getWaktuTutup())) {
            for (TourGuideModel tourGuide : agensi.getListTourGuide()) {
                tourGuideService.deleteTourGuide(tourGuide);
            }
            model.addAttribute("noAgensi", agensi.getNoAgensi());
            return "delete-tour-guide";
        }
        return "null-agensi";

//        model.addAttribute("noAgensi", agensi.getNoAgensi());
//        for (TourGuideModel tourGuide : agensi.getListTourGuide()) {
//            TourGuideModel deletedTourGuide = tourGuideService.deleteTourGuide(tourGuide);
//            if (deletedTourGuide == null) return "null-agensi";
//        }
//        return "delete-tour-guide"; // buatan ku
    }
}