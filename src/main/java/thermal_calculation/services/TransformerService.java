package thermal_calculation.services;

import thermal_calculation.repositories.TransformerRepository;
import thermal_calculation.models.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransformerService {
    private final TransformerRepository transformerRepository;

    public List<Transformer> list(){
        return transformerRepository.findAll();}

    public void saveTrans(Transformer transformer){
        transformerRepository.save(transformer);
    }

    public void delete(Long id){
        transformerRepository.deleteById(id);
    }

    public Transformer getTrByID(Long id){
        return transformerRepository.findById(id).orElse(null);
    }
}
