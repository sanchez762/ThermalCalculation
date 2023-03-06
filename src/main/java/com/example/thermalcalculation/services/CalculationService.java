package com.example.thermalcalculation.services;

import com.example.thermalcalculation.transformer.Calculation;
import com.example.thermalcalculation.transformer.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculationService {
    private final Calculation calculation;

    public void setLoad(double[] power){
        calculation.power = power;
    }

    public void setTrans(Transformer tr){
        calculation.trans = tr;
    }
    public void calculation(){
        calculation.calculation();
    }
    public List<List<Map<Object,Object>>> result(){
        return calculation.list;
    }
    public void setParam(double temperature, int n, double smax, double iter, double tmMax, double tnntMax){
        calculation.temperature = temperature;
        calculation.n = n;
        calculation.smax = smax;
        calculation.iter = iter;
        calculation.tmMax = tmMax;
        calculation.tnntMax = tnntMax;
    }

    public Transformer getTr(){
        return calculation.trans;
    }
    public double[] getPower(){
        return calculation.power;
    }
    public boolean[] getCondition(){
        return calculation.condition;
    }
}
