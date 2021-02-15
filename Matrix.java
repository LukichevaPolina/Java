package com.company;
import java.util.Scanner;
public class Matrix {
    int str_num;
    int col_num;
    Complex[][] matrix;

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

    public static Matrix Add(Matrix first, Matrix second) {
        if (!(first.str_num == second.str_num && first.col_num == second.col_num)) {
            return null;
        }
        Matrix new_m = new Matrix(first.str_num, second.col_num);
        for (int i = 0; i < first.str_num; ++i) {
            for (int j = 0; j < first.col_num; ++j) {
                new_m.matrix[i][j] = Complex.Add(first.matrix[i][j], second.matrix[i][j]);
            }
        }
        return new_m;
    }

    public static Matrix Sub(Matrix first, Matrix second) {
        if (!(first.str_num == second.str_num && first.col_num == second.col_num)) {
            return null;
        }
        Matrix new_m = new Matrix(first.str_num, second.col_num);
        for (int i = 0; i < first.str_num; ++i) {
            for (int j = 0; j < first.col_num; ++j) {
                new_m.matrix[i][j] = Complex.Sub(first.matrix[i][j], second.matrix[i][j]);
            }
        }
        return new_m;
    }

    public static Matrix MuttNum(Matrix m, Complex num) {
        for (int i = 0; i < m.str_num; ++i) {
            for (int j = 0; j < m.col_num; ++j) {
                m.matrix[i][j] = Complex.Mutt(m.matrix[i][j], num);
            }
        }
        return m;
    }


    public static Matrix MuttMat(Matrix first, Matrix second) {
        if (!(first.col_num == second.str_num)) {
            return null;
        }
        Matrix new_m = new Matrix(first.str_num, second.col_num);
        for (int i = 0; i < second.col_num; ++i) {
            for (int j = 0; j < first.str_num; ++j) {
                for (int k = 0; k < first.col_num; ++k) {
                    new_m.matrix[j][i] = Complex.Add(new_m.matrix[j][i], Complex.Mutt(first.matrix[j][k],second.matrix[k][i]));
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
        if (!(this == null)){
            for (int i = 0; i < str_num; ++i) {
                for (int j = 0; j < col_num; ++j) {
                    matrix[i][j].print();
                }
                System.out.print("\n");
            }
        }
        else {
            System.out.print("Exception");
        }
    }
}
