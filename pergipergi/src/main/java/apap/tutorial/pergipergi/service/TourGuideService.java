package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;

import java.time.LocalTime;

public interface TourGuideService {

    void addTourGuide(TourGuideModel tourGuide);

    TourGuideModel getGuideByNoTourGuide(Long noTourGuide);

    // Method untuk mengupdate tour guide
    TourGuideModel updateTourGuide(TourGuideModel tourGuide);

    TourGuideModel deleteTourGuide(TourGuideModel tourGuide);

}