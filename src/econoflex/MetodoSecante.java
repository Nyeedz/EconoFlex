/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econoflex;

/**
 *
 * @author ruancaetano
 */
public class MetodoSecante {

    private double r, c, x0, x1, precisao;
    private int inter;

    public MetodoSecante(double raio, double comp) {
        r = raio;
        c = comp;
        precisao = 0.1;
    }

    public int getInter (){
        return inter;
    } 
    public double getPrecisao(){
        return precisao;
    }
    
    public double f(double h, double volume) {
        return (Math.abs((h - r) * (Math.sqrt(Math.pow(r, 2) - Math.pow((h - r), 2)))
                + Math.pow(r, 2) * (Math.asin((h - r) / r) + Math.PI / 2)) * c) - volume;
    }

    public double executaMetodo(double vol) {
        inter = 0;
        x0 = 0;
        x1 = 30;
        double subtracao = Math.abs(x0 - x1);
        double x = 0.0;

        while (subtracao > precisao) {
            x = ((x0 * f(x1, vol)) - (x1 * f(x0, vol))) / (f(x1, vol) - f(x0, vol));
            subtracao = Math.abs(x - x1);
            x0 = x1;
            x1 = x;
            inter++;
        }
        return x;
    }

}
