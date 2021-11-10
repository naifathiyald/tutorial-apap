package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;
import apap.tutorial.pergipergi.rest.Setting;
import apap.tutorial.pergipergi.rest.TourGuideDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
public class TourGuideRestServiceImpl implements TourGuideRestService {

    private final WebClient webClient;

    public TourGuideRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.umurUrl).build();
    }

    @Autowired
    TourGuideDb tourGuideDb;

    @Override
    public List<TourGuideModel> retrieveListTourGuide() {
        return tourGuideDb.findAll();
    }

    @Override
    public TourGuideModel getTourGuideByNoTourGuide(Long noTourGuide) {
        Optional<TourGuideModel> tourGuide = tourGuideDb.findByNoTourGuide(noTourGuide);

        if (tourGuide.isPresent()) {
            return tourGuide.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public TourGuideModel getUmur(Long noTourGuide) {
        TourGuideModel tourGuide = getTourGuideByNoTourGuide(noTourGuide);
        Mono<TourGuideDetail> detailMono = this.webClient.get().uri("?name=" + tourGuide.getNamaTourGuide()).retrieve().bodyToMono(TourGuideDetail.class);

        tourGuide.setUmur(detailMono.block().getAge());
        tourGuideDb.save(tourGuide);
        return tourGuide;
    }
}
