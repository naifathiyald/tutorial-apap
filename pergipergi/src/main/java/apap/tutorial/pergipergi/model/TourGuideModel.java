package apap.tutorial.pergipergi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tour_guide")
@JsonIgnoreProperties(value={"agensi"},allowSetters = true)
public class TourGuideModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noTourGuide;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_tour_guide", nullable = false)
    private String namaTourGuide;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private Integer jenisKelamin;

    @Column(name = "umur", nullable = true)
    private Integer umur;

    // Relasi dengan AgensiModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "no_agensi", referencedColumnName = "noAgensi", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TravelAgensiModel agensi;

}
