package thermal_calculation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cooling_systems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoolingSystem {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="X")
    private double x;

    @Column(name="Y")
    private double y;

    @Column(name="tau")
    private double tau;

    @Column(name="Vm")
    private double vm;

    @Column(name="Vnnt")
    private double vnnt;
}
