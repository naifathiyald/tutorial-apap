package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.rest.TourGuideDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TourGuideRestService {

    List<TourGuideModel> retrieveListTourGuide();
    TourGuideModel getTourGuideByNoTourGuide(Long noTourGuide);
    TourGuideModel getUmur(Long noTourGuide);
}
