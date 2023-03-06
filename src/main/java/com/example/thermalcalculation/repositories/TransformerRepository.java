package com.example.thermalcalculation.repositories;

import com.example.thermalcalculation.transformer.Transformer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransformerRepository extends JpaRepository<Transformer, Long>{
    List<Transformer> findByName(String name);
}