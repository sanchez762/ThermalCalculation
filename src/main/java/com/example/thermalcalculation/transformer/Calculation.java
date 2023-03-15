package com.example.thermalcalculation.transformer;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Calculation {
    public Transformer trans;
    public double[] power;
    public int n;
    public double t;
    public double smax;
    public double iter;
    public double tmMax;
    public double tnntMax;

    public List<List<Map<Object,Object>>> list = new ArrayList<>();
    private final double[] sCalc = new double[24];
    private final double[] k = new double[24];
    private final double[] k2 = new double[24];
    private final double[] vmust = new double[24];
    private final double[] vnntust = new double[24];
    private final double[] vmt = new double[25];
    private final double[] tm = new double[24];
    private final double[] tnnt = new double[24];
    private final double[] delta = new double[24];

    public void calculation(){

        double d = (double) trans.getPk()/trans.getPxx();
        double tm0 = 0;
        double vnntustL = 0;
        double tnntL = 0;

        for(int i = 0; i <24; i++){
            sCalc[i] = smax * (power[i] / 100);
        }
        vmt[0] = 0;
        delta[0] = 0;
        for(int i = 1; i <= iter; i++){
            for(int j = 0; j < 24; j++){
                k[j] = sCalc[j] / (trans.getPower() * n);
                k2[j] = Math.pow(k[j], 2);
                vmust[j] = trans.getVm() * Math.pow((1+d*k2[j]) / (1+d), trans.getX());
                vnntust[j] = trans.getVnnt() * Math.pow(k[j], trans.getY());
                vmt[j+1] = vmust[j] + (vmt[j] - vmust[j]) * Math.exp(-1/(double)trans.getTau());
                tm[j] = vmt[j+1] + t;
                tnnt[j] = tm[j] + vnntust[j];
                if(j == 0){
                    delta[j] = vnntust[j] - vnntustL;
                }
                else delta[j] = vnntust[j] - vnntust[j-1];
            }
            tm0 = tm[23];
            vmt[0] = vmt[24];
            vnntustL = vnntust[23];
            tnntL = tnnt[23];
        }

        double[] tmChart = new double[25];
        tmChart[0] = tm0;
        System.arraycopy(tm, 0, tmChart, 1, tmChart.length - 1);
        chart(tmChart);

        double[] tnntChart = new double[48];
        tnntChart[0] = tnntL + delta[0];
        for (int i = 1; i < 24; i++){
            tnntChart[i*2 - 1] = tnnt[i-1];
            tnntChart[i*2] = tnntChart[i*2 - 1] + delta[i];
        }
        tnntChart[47] = tnnt[23];
        chartNnt(tnntChart);

        chart(tmMax);
        chart(tnntMax);
    }

    private void chart(double[] listChart) {
        Map<Object,Object> map;
        List<Map<Object,Object>> dataPoints = new ArrayList<>();

        for(int i = 0; i <= 24; i++){
            map = new HashMap<>();
            map.put("x", i);
            map.put("y", listChart[i]);
            dataPoints.add(map);
        }
        list.add(dataPoints);
    }
    private void chartNnt(double[] listChartNnt) {
        Map<Object,Object> map;
        List<Map<Object,Object>> dataPoints = new ArrayList<>();

        for(int i = 1; i <= 48; i++){
            map = new HashMap<>();
            map.put("x", i/2);
            map.put("y", listChartNnt[i-1]);
            dataPoints.add(map);
        }
        list.add(dataPoints);
    }
    private void chart(double max) {
        Map<Object,Object> map;
        List<Map<Object,Object>> dataPointsMax = new ArrayList<>();

        for(int i = 0; i <= 24; i++){
            map = new HashMap<>();
            map.put("x", i);
            map.put("y", max);
            dataPointsMax.add(map);
        }
        list.add(dataPointsMax);
    }


}