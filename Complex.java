package com.company;

import java.text.DecimalFormat;

public class Complex {
    private double a;
    private double b;
    private boolean isAlgebraic;

    public Complex() {
        a = 0;
        b = 0;
        isAlgebraic = true;
    }
    public Complex(double _a){
        a = _a;
        b = 0;
        isAlgebraic = true;
    }

    public Complex(double _a, double _b){
        a = _a;
        b = _b;
        isAlgebraic = true;
    }

    public Complex Add(Complex second) {
        toAlg();
        second.toAlg();
        return (new Complex(a + second.a, b + second.b));
    }

    public Complex Sub(Complex second) {
        toAlg();
        second.toAlg();
        return (new Complex(a - second.a, b - second.b));
    }

    public Complex Mutt(Complex second){
        toAlg();
        second.toAlg();
        return (new Complex (a * second.a - b * second.b,a * second.b + b * second.a));
    }

    public Complex Div(Complex second){
        toAlg();
        second.toAlg();
        return (new Complex ((a * second.a + b * second.b) / (second.a * second.a + second.b * second.b),
                (b * second.a - a * second.b) / (second.a * second.a + second.b * second.b)));
    }

    public void toTrig(){
        if (isAlgebraic) {
            isAlgebraic = false;
            a = Math.sqrt(a * a + b * b); // r
            b = Math.atan(b / a) * 180 / Math.PI; // fi
        }
    }

    public void toAlg() {
        if (!isAlgebraic) {
            isAlgebraic = true;
            double r = a;
            a = r * Math.cos(b);
            b = r * Math.sin(b);
        }
    }

    public void print() {
        if (isAlgebraic){
            if (b > 0) {
                System.out.println(a + " + " + b + "i");
            }
            else if (b < 0) {
                System.out.println(a + " - " + Math.abs(b) + "i");
            }
            else {
                System.out.println(a);
            }
        }
        else {
            DecimalFormat df = new DecimalFormat("#.###");
            String _a = df.format(a);
            String _b = df.format(b);
            System.out.println(_a + "(cos(" + _b + ") + sin(" + _b + "))");
        }
    }
    public static void main(String[] args) {
        Complex a = new Complex(5, 6);
        a.print();
        Complex b = new Complex (7, 8);
        b.print();
        a.Add(b).print();
        Complex c = new Complex(4);
        c.print();
    }
}

