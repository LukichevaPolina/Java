package com.company;

public class Main {
    public static void main(String[] argc) {

        Complex c1 = new Complex (1, 1);
        Complex c2 = new Complex (3, 4);
        Complex.Add(c1, c2).print();
        // 4.0 + 5.0i
        Complex.Sub(c1, c2).print();
        //-2.0 - 3.0i
        Complex.Mutt(c1, c2).print();
        //-1.0 + 7.0i
        Complex.Div(c1, c2).print();
        //0.28 - 0.04i
        c1.toTrig();
        c1.print();
        //1,414(cos(35,264) + sin(35,264))

        Matrix m1 = Matrix.Read();
        Matrix m2 = Matrix.Read();
        Matrix.Add(m1, m2).print();
        Matrix.Sub(m1, m2).print();
        Matrix.MuttMat(m1, m2).print();
    }
}
