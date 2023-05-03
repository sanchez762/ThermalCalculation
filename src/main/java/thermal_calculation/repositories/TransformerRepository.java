package thermal_calculation.repositories;

import thermal_calculation.models.Transformer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransformerRepository extends JpaRepository<Transformer, Long>{
}