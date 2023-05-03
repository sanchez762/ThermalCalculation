package thermal_calculation.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="transformers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "power")
    private int power;
    @Column(name = "pk")
    private int pk;
    @Column(name = "pxx")
    private int pxx;
    @ManyToOne
    @JoinColumn(name = "cooling_systems_id")
    private CoolingSystem coolingSystem;
}
