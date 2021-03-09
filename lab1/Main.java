package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] argc) {

        Complex c1 = new Complex(1, 1);
        Complex c2 = new Complex(3, 4);
        c1.Add(c2).print();
        // 4.0 + 5.0i
        c1.Sub(c2).print();
        //-2.0 - 3.0i
        c1.Mutt(c2).print();
        //-1.0 + 7.0i
        c1.Div(c2).print();
        //0.28 - 0.04i
        c1.toTrig();
        c1.print();
        //1,414(cos(35,264) + sin(35,264))

        System.out.println("Enter size of matrix:");
        Scanner in = new Scanner(System.in);
        int str_num = in.nextInt();
        int col_num = in.nextInt();
        Matrix m1 = new Matrix(str_num, col_num);
        for (int i = 0; i < str_num; ++i) {
            System.out.println("Enter str: " + (i+1));
            for (int j = 0; j < col_num; ++j) {
                double a = in.nextDouble();
                double b = in.nextDouble();
                m1.SetValue(new Complex(a, b), i, j);
            }
        }

        System.out.println("Enter size of matrix:");
        Scanner in2 = new Scanner(System.in);
        int str_num2 = in.nextInt();
        int col_num2 = in.nextInt();
        Matrix m2 = new Matrix(str_num2, col_num2);
        for (int i = 0; i < str_num2; ++i) {
            System.out.println("Enter str: " + (i+1));
            for (int j = 0; j < col_num2; ++j) {
                double a = in.nextDouble();
                double b = in.nextDouble();
                m2.SetValue(new Complex(a, b), i, j);
            }
        }
        
        m1.Add(m2).print();
        m1.Sub(m2).print();
    }
}
