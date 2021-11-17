package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.DestinasiModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;

import java.util.List;

public interface DestinasiRestService {
    DestinasiModel createDestinasi(DestinasiModel destinasi);
    List<DestinasiModel> retrieveListDestinasi();
    DestinasiModel getDestinasiByNoDestinasi(Long noDestinasi);
    DestinasiModel updateDestinasi(Long noDestinasi, DestinasiModel destinasiUpdate);
    void deleteDestinasi(Long noDestinasi);
}
