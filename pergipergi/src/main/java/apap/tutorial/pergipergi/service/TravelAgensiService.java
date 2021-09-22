package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import java.util.List;

//public interface TravelAgensiService {
//    // Method untuk menambahkan agensi
//    void addAgensi(TravelAgensiModel travelAgensi);
//
//    // Method untuk mendapatkan daftar agensi yang telah tersimpan
//    List<TravelAgensiModel> getListAgensi();
//
//    // Method untuk mendapatkan data agensi berdasarkan id agensi
//    TravelAgensiModel getAgensiByidAgensi(String idAgensi);
//
//    // Method untuk mengupdate no telepon
//    void updateNoTeleponByidAgensi(String idAgensi, String noTelepon);
//
//    // Method untuk menghapus agensi
//    void deleteAgensiByidAgensi(String idAgensi);
//
//}

public interface TravelAgensiService {
    void addAgensi(TravelAgensiModel travelAgensi);
    List<TravelAgensiModel> getListAgensi();
    TravelAgensiModel getAgensiByNoAgensi(Long noAgensi);
    TravelAgensiModel updateAgensi(TravelAgensiModel travelAgensi);

    // Method untuk menghapus agensi
    TravelAgensiModel deleteAgensi(TravelAgensiModel travelAgensi);

    // Method untuk menghapus tour guide
//    TourGuideModel deleteTourGuide(TourGuideModel tourGuide);
}