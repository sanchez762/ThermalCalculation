package thermal_calculation.transformer;

import thermal_calculation.models.CoolingSystem;
import thermal_calculation.models.Transformer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Calculation {
    public Transformer trans;
    public CoolingSystem coolingSystem;
    public double[] power;
    public int n;
    public double temperature;
    public double smax;
    public double iter;
    public double tmMax;
    public double tnntMax;
    public List<List<Map<Object,Object>>> list = new ArrayList<>();
    public boolean[] condition;
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

        list.clear();

        double d = (double) trans.getPk()/trans.getPxx();
        double tm0 = 0;
        double vnntustL = 0;
        double tnntL = 0;

        for(int i = 0; i <24; i++){
            sCalc[i] = smax * (power[i] / 100);
        }

        double s = trans.getPower();
        double vm = coolingSystem.getVm();
        double x = coolingSystem.getX();
        double y = coolingSystem.getY();
        double tau = coolingSystem.getTau();
        double vnnt = coolingSystem.getVnnt();

        vmt[0] = 0;
        delta[0] = 0;
        for(int i = 1; i <= iter; i++){
            for(int j = 0; j < 24; j++){
                k[j] = sCalc[j] / (s * n);
                k2[j] = Math.pow(k[j], 2);
                vmust[j] = vm * Math.pow((1+d*k2[j]) / (1+d), x);
                vnntust[j] = vnnt * Math.pow(k[j], y);
                vmt[j+1] = vmust[j] + (vmt[j] - vmust[j]) * Math.exp(-1/tau);
                tm[j] = vmt[j+1] + temperature;
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
        chartM(tmChart);

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

        boolean[] cond = new boolean[2];
        boolean tmCondition = true;
        boolean tnntCondition = true;

        for (double t : tm) {
            if (t > tmMax) {
                tmCondition = false;
                break;
            }
        }
        cond[0] = tmCondition;

        for (double t : tnnt) {
            if (t > tnntMax) {
                tnntCondition = false;
                break;
            }
        }
        cond[1] = tnntCondition;
        condition = cond;
    }

    private void chartM(double[] listChart) {
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
