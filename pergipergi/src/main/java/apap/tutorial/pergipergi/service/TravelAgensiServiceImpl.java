package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Optional;
import java.util.List;

//public class TravelAgensiServiceImpl implements TravelAgensiService {
//
//    private List<TravelAgensiModel> listAgensi;
//
//    public TravelAgensiServiceImpl() {
//        listAgensi = new ArrayList<>();
//    }
//
//    @Override
//    public void addAgensi(TravelAgensiModel travelAgensiModel) {
//        listAgensi.add(travelAgensiModel);
//    }
//
//    @Override
//    public List<TravelAgensiModel> getListAgensi() {
//        return listAgensi;
//    }
//
//    @Override
//    public TravelAgensiModel getAgensiByidAgensi(String idAgensi) {
//        for (TravelAgensiModel agensi : listAgensi) {
//            if (agensi.getIdAgensi().equalsIgnoreCase(idAgensi)) {
//                return agensi;
//            }
//            // break;
//        }
//        return null;
//    }
//
//    @Override
//    public void updateNoTeleponByidAgensi(String idAgensi, String noTelepon) {
//        for (TravelAgensiModel agensi : listAgensi) {
//            if (agensi.getIdAgensi().equalsIgnoreCase(idAgensi)) {
//                agensi.setNoTelepon(noTelepon);
//            }
//            // break;
//        }
//    }
//
//    @Override
//    public void deleteAgensiByidAgensi(String idAgensi) {
//        List<TravelAgensiModel> toDelete = new ArrayList<>();
//        for (TravelAgensiModel agensi : listAgensi) {
//            if (agensi.getIdAgensi().equalsIgnoreCase(idAgensi)) {
//                toDelete.add(agensi);
//            }
//        }
//        listAgensi.removeAll(toDelete);
//    }
//}


@Service
@Transactional
public class TravelAgensiServiceImpl implements TravelAgensiService {

    @Autowired
    TravelAgencyDb travelAgensiDb;
    TourGuideDb tourGuideDb;

    @Override
    public void addAgensi(TravelAgensiModel travelAgensi) {
        travelAgensiDb.save(travelAgensi);
    }

    @Override
    public List<TravelAgensiModel> getListAgensi() {
        // Menampilkan seluruh agensi terurut
        // https://www.baeldung.com/spring-data-sorting
        return travelAgensiDb.findAll(Sort.by(Sort.Direction.ASC, "namaAgensi"));
    }

    @Override
    public TravelAgensiModel getAgensiByNoAgensi(Long noAgensi) {
        Optional<TravelAgensiModel> agensi = travelAgensiDb.findByNoAgensi(noAgensi);
        if(agensi.isPresent()) return agensi.get();
        else return null;
    }

    @Override
    public TravelAgensiModel updateAgensi(TravelAgensiModel travelAgensi) {
        travelAgensiDb.save(travelAgensi);
        return travelAgensi;
    }

    @Override
    public TravelAgensiModel deleteAgensi(TravelAgensiModel travelAgensi) {
        if (travelAgensi.getListTourGuide().size() == 0) {
            if (!(LocalTime.now().isAfter(travelAgensi.getWaktuBuka()) && LocalTime.now().isBefore(travelAgensi.getWaktuTutup()))) {
                travelAgensiDb.delete(travelAgensi);
                return travelAgensi;
            }
        }
        return null;
    }

//    @Override
//    public TourGuideModel deleteTourGuide(TourGuideModel tourGuide) {
//        if (!(LocalTime.now().isAfter(tourGuide.getAgensi().getWaktuBuka()) && LocalTime.now().isBefore(tourGuide.getAgensi().getWaktuTutup()))) {
//            tourGuideDb.delete(tourGuide);
//            return tourGuide;
//        }
//        return null;
//    }

}