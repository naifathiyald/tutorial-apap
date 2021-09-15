package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TravelAgensiModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TravelAgensiServiceImpl implements TravelAgensiService {

    private List<TravelAgensiModel> listAgensi;

    public TravelAgensiServiceImpl() {
        listAgensi = new ArrayList<>();
    }

    @Override
    public void addAgensi(TravelAgensiModel travelAgensiModel) {
        listAgensi.add(travelAgensiModel);
    }

    @Override
    public List<TravelAgensiModel> getListAgensi() {
        return listAgensi;
    }

    @Override
    public TravelAgensiModel getAgensiByidAgensi(String idAgensi) {
        for (TravelAgensiModel agensi : listAgensi) {
            if (agensi.getIdAgensi().equalsIgnoreCase(idAgensi)) {
                return agensi;
            }
            // break;
        }
        return null;
    }

    @Override
    public void updateNoTeleponByidAgensi(String idAgensi, String noTelepon) {
        for (TravelAgensiModel agensi : listAgensi) {
            if (agensi.getIdAgensi().equalsIgnoreCase(idAgensi)) {
                agensi.setNoTelepon(noTelepon);
            }
            // break;
        }
    }

    @Override
    public void deleteAgensiByidAgensi(String idAgensi) {
        List<TravelAgensiModel> toDelete = new ArrayList<>();
        for (TravelAgensiModel agensi : listAgensi) {
            if (agensi.getIdAgensi().equalsIgnoreCase(idAgensi)) {
                toDelete.add(agensi);
            }
        }
        listAgensi.removeAll(toDelete);
    }
}
