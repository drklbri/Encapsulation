package ru.vsu.cs.shevchenko_daniil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координаты треугольника:\n");
        double x1 = sc.nextDouble(); double y1 = sc.nextDouble();
        double x2 = sc.nextDouble(); double y2 = sc.nextDouble();
        double x3 = sc.nextDouble(); double y3 = sc.nextDouble();
        Triangle triangle = TriangleMethods.CoordIntoTriangle(x1, y1, x2, y2, x3, y3);
        double area = TriangleMethods.Area(triangle);
        double perimeter = TriangleMethods.Perimeter(triangle);
        System.out.println("Площадь: " + area);
        System.out.println("Периметр: " + perimeter);

        System.out.println("Введите координаты произвольной точки:");
        double x0 = sc.nextDouble(); double y0 = sc.nextDouble();
        Point point = new Point(x0, y0);
        if (TriangleMethods.IsPointInTriangle(triangle, point)){
            System.out.println("Точка находится в треугольнике");
        } else {
            System.out.println("Точка вне треугольника");
        }

    }
}
