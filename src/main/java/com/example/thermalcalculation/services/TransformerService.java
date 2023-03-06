package com.example.thermalcalculation.services;

import com.example.thermalcalculation.repositories.TransformerRepository;
import com.example.thermalcalculation.transformer.Transformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransformerService {
    private final TransformerRepository transformerRepository;

    public List<Transformer> list(String name){
        if (name != null) return transformerRepository.findByName(name);
        return transformerRepository.findAll();}

    public void saveTrans(Transformer transformer){
        log.info("Saving new{}", transformer);
        transformerRepository.save(transformer);
    }

    public void delete(Long id){
        transformerRepository.deleteById(id);
    }

    public Transformer getTrByID(Long id){
        return transformerRepository.findById(id).orElse(null);
    }
}
