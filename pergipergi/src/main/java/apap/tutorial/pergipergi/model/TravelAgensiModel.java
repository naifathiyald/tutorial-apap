package apap.tutorial.pergipergi.model;

//public class TravelAgensiModel {
//    private String idAgensi;
//    private String namaAgensi;
//    private String alamat;
//    private String noTelepon;
//
//    public TravelAgensiModel(String idAgensi, String namaAgensi, String alamat, String noTelepon) {
//        this.idAgensi = idAgensi;
//        this.namaAgensi = namaAgensi;
//        this.alamat = alamat;
//        this.noTelepon = noTelepon;
//    }
//
//    public String getIdAgensi() {
//        return idAgensi;
//    }
//
//    public void setIdAgensi(String idAgensi) {
//        this.idAgensi = idAgensi;
//    }
//
//    public String getNamaAgensi() {
//        return namaAgensi;
//    }
//
//    public void setNamaAgensi(String namaAgensi) {
//        this.namaAgensi = namaAgensi;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public String getNoTelepon() {
//        return noTelepon;
//    }
//
//    public void setNoTelepon(String noTelepon) {
//        this.noTelepon = noTelepon;
//    }
//
//}

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travel_agensi")
public class TravelAgensiModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noAgensi;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_agensi", nullable = false)
    private String namaAgensi;

    @NotNull
    @Size(max = 30)
    @Column(name = "alamat_agensi", nullable = false)
    private String alamatAgensi;

    @NotNull
    @Size(max = 30)
    @Column(name = "no_telepon_agensi", nullable = false)
    private String noTeleponAgensi;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuTutup;

    // Relasi dengan TourGuideHotel
    @OneToMany(mappedBy = "agensi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TourGuideModel> listTourGuide;

    // Relasi dengan DestinasiModel
    @ManyToMany
    @JoinTable(
            name = "agensi_destinasi",
            joinColumns = @JoinColumn(name = "no_agensi"),
            inverseJoinColumns = @JoinColumn(name = "no_destinasi")
    )
    List<DestinasiModel> listDestinasi;

}