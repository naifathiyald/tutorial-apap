package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional
public class TourGuideServiceImpl implements TourGuideService {

    @Autowired
    TourGuideDb tourGuideDb;

    @Override
    public void addTourGuide(TourGuideModel tourGuide) {
        tourGuideDb.save(tourGuide);
    }

    @Override
    public TourGuideModel getGuideByNoTourGuide(Long noTourGuide) {
        Optional<TourGuideModel> tourGuide = tourGuideDb.findByNoTourGuide(noTourGuide);
        if(tourGuide.isPresent()) return tourGuide.get();
        else return null;
    }

    @Override
    public TourGuideModel updateTourGuide(TourGuideModel tourGuide) {
        if (!(LocalTime.now().isAfter(tourGuide.getAgensi().getWaktuBuka()) && LocalTime.now().isBefore(tourGuide.getAgensi().getWaktuTutup()))) {
            tourGuideDb.save(tourGuide);
            return tourGuide;
        }
        return null;
    }

    @Override
    public TourGuideModel deleteTourGuide(TourGuideModel tourGuide) {
        if (!(LocalTime.now().isAfter(tourGuide.getAgensi().getWaktuBuka()) && LocalTime.now().isBefore(tourGuide.getAgensi().getWaktuTutup()))) {
            tourGuideDb.delete(tourGuide);
            return tourGuide;
        }
        return null;
    }
}