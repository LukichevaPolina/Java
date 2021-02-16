package com.company;
import java.util.Scanner;
public class Matrix {
    int str_num;
    int col_num;
    Complex[][] matrix;

    public Matrix() {
        str_num = 10;
        col_num = 10;
        matrix = new Complex[10][10];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                matrix[i][j] = new Complex();
            }
        }
    }

    public Matrix(int _str_num, int _col_num) {
        str_num = _str_num;
        col_num =_col_num;
        matrix = new Complex[_str_num][_col_num];
        for (int i = 0; i < _str_num; ++i) {
            for (int j = 0; j < _col_num; ++j) {
                matrix[i][j] = new Complex();
            }
        }
    }

    public static Matrix Read() {
        Scanner in = new Scanner(System.in);
        int str_num = in.nextInt();
        int col_num = in.nextInt();
        Matrix m = new Matrix(str_num, col_num);
        for (int i = 0; i < str_num; ++i)
            for (int j = 0; j < col_num; ++j) {
                double a = in.nextDouble();
                double b = in.nextDouble();
                m.matrix[i][j] = new Complex(a, b);
            }
        return m;
    }

    public Matrix Add(Matrix second) {
        if (!(str_num == second.str_num && col_num == second.col_num)) {
            return null;
        }
        Matrix m = new Matrix(str_num, col_num);
        for (int i = 0; i < str_num; ++i) {
            for (int j = 0; j < col_num; ++j) {
                m.matrix[i][j] = matrix[i][j].Add(second.matrix[i][j]);
            }
        }
        return m;
    }

    public Matrix Sub(Matrix second) {
        if (!(str_num == second.str_num && col_num == second.col_num)) {
            return null;
        }
        Matrix m = new Matrix(str_num, col_num);
        for (int i = 0; i < str_num; ++i) {
            for (int j = 0; j < col_num; ++j) {
                m.matrix[i][j] = matrix[i][j].Sub(second.matrix[i][j]);
            }
        }
        return m;
    }

    public Matrix MuttNum(Complex num) {
        Matrix m = new Matrix(str_num, col_num);
        for (int i = 0; i < str_num; ++i) {
            for (int j = 0; j < col_num; ++j) {
                m.matrix[i][j].Mutt(num);
            }
        }
        return m;
    }


    public Matrix MuttMat(Matrix second) {
        if (!(col_num == second.str_num)) {
            matrix = null;
        }
        Matrix new_m = new Matrix(str_num, second.col_num);
        for (int i = 0; i < second.col_num; ++i) {
            for (int j = 0; j < str_num; ++j) {
                for (int k = 0; k < col_num; ++k) {
                    new_m.matrix[j][i].Add(matrix[j][k].Mutt(second.matrix[k][i]));
                }
            }
        }
        return new_m;
    }

    public static Matrix Transponse(Matrix matr) {
        Matrix new_m = new Matrix(matr.col_num, matr.str_num);
        for (int i = 0; i < matr.str_num; ++i) {
            for (int j = 0; j < matr.col_num; ++j) {
                new_m.matrix[j][i] = matr.matrix[i][j];
            }
        }
        return new_m;
    }

    public void print() {
        try {
            for (int i = 0; i < str_num; ++i) {
                for (int j = 0; j < col_num; ++j) {
                    matrix[i][j].print();
                }
                System.out.print("\n");
            }
        }
        catch(NullPointerException e) {
            System.out.print("Exception");
        }
    }
}
