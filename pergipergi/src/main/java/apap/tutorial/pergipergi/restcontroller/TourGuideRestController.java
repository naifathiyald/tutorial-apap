package apap.tutorial.pergipergi.restcontroller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.rest.AgensiDetail;
import apap.tutorial.pergipergi.rest.TourGuideDetail;
import apap.tutorial.pergipergi.service.TourGuideRestService;
import apap.tutorial.pergipergi.service.TourGuideService;
import apap.tutorial.pergipergi.service.TravelAgensiRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class TourGuideRestController {

    @Autowired
    private TourGuideRestService tourGuideRestService;

    @GetMapping(value = "/list-tour-guide")
    private List<TourGuideModel> retrieveListTourGuide() {

        return tourGuideRestService.retrieveListTourGuide();
    }

    @GetMapping(value = "/tour/umur/{noTourGuide}")
    private TourGuideModel getUmur(
            @PathVariable("noTourGuide") Long noTourGuide
    ) {
        try {
            return tourGuideRestService.getUmur(noTourGuide);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Tour Guide with No TourGuide " + String.valueOf(noTourGuide) + " Not Found."
            );
        }

    }

}
