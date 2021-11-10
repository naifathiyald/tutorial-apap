package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.repository.TravelAgencyDb;

import apap.tutorial.pergipergi.rest.AgensiDetail;
import apap.tutorial.pergipergi.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.*;
import java.time.*;


@Service
@Transactional
public class TravelAgensiRestServiceImpl implements TravelAgensiRestService {

    private final WebClient webClient;

    public TravelAgensiRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.agensiUrl).build();
    }

    @Autowired
    private TravelAgencyDb travelAgencyDb;

    @Override
    public TravelAgensiModel createAgensi(TravelAgensiModel agensi) {
        return travelAgencyDb.save(agensi);
    }

    @Override
    public List<TravelAgensiModel> retrieveListAgensi() {
        return travelAgencyDb.findAll();
    }

    @Override
    public TravelAgensiModel getAgensiByNoAgensi(Long noAgensi) {
        Optional<TravelAgensiModel> agensi = travelAgencyDb.findByNoAgensi(noAgensi);

        if (agensi.isPresent()) {
            return agensi.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public TravelAgensiModel updateAgensi(Long noAgensi, TravelAgensiModel agensiUpdate) {
        TravelAgensiModel Agensi = getAgensiByNoAgensi(noAgensi);
        Agensi.setNamaAgensi(agensiUpdate.getNamaAgensi());
        Agensi.setAlamatAgensi(agensiUpdate.getAlamatAgensi());
        Agensi.setNoTeleponAgensi(agensiUpdate.getNoTeleponAgensi());
        Agensi.setWaktuBuka(agensiUpdate.getWaktuBuka());
        Agensi.setWaktuTutup(agensiUpdate.getWaktuTutup());

        return travelAgencyDb.save(Agensi);
    }

    @Override
    public void deleteAgensi(Long noAgensi) {
        LocalTime now = LocalTime.now();
        TravelAgensiModel Agensi = getAgensiByNoAgensi(noAgensi);

        if ((now.isBefore(Agensi.getWaktuBuka()) || now.isAfter(Agensi.getWaktuTutup()))
        && Agensi.getListTourGuide().isEmpty()) {
            travelAgencyDb.delete(Agensi);
        } else{
            throw new UnsupportedOperationException("Agensi is still open!");
        }
    }

    @Override
    public Mono<String> getStatus(Long noAgensi) {
        return this.webClient.get().uri("/rest/agensi/" + noAgensi + "/status").retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<AgensiDetail> postStatus() {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("namaAgensi", "Agensi Mock Server");
        data.add("alamatAgensi", "Depok");

        return this.webClient.post().uri("rest/agensi/full")
                .syncBody(data)
                .retrieve()
                .bodyToMono(AgensiDetail.class);
    }

//
//    public TravelAgensiRestServiceImpl(WebClient.Builder webClientBuilder){
//        this.webClient = webClientBuilder.baseUrl(Setting.agensiUrl).build();
//    }
}
