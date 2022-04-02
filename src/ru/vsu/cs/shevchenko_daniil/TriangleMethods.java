package ru.vsu.cs.shevchenko_daniil;

public class TriangleMethods {


    public static Triangle CoordIntoTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);

        Triangle triangle = new Triangle(p1, p2, p3);
        return triangle;
    }

    public static double Area(Triangle triangle) throws Exception {
        /*
        Площадь треугольника по координатам трёх точек вычисляется по формуле:
        1/2 * |(x2-x1)(y3-y1) - (x3-x1)(y2-y1)|
         */

        if (degenerateTriangleCheck(triangle)) {
            throw new Exception("Degenerate triangle");
        }

        double x1 = triangle.p1.getX();
        double y1 = triangle.p1.getY();
        double x2 = triangle.p2.getX();
        double y2 = triangle.p2.getY();
        double x3 = triangle.p3.getX();
        double y3 = triangle.p3.getY();

        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;

    }

    public static double Perimeter(Triangle triangle) {
        /*
        |AB| = sqrt((x1 - x2)^2 + (y1 - y2)^2)
        A - point 1, B - point 2, C - point 3
         */


        double x1 = triangle.p1.getX();
        double y1 = triangle.p1.getY();
        double x2 = triangle.p2.getX();
        double y2 = triangle.p2.getY();
        double x3 = triangle.p3.getX();
        double y3 = triangle.p3.getY();

        double AB = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double BC = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double AC = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        return AB + BC + AC;
    }

    public static boolean IsPointInTriangle(Triangle triangle, Point point) throws Exception {
        /*
        (x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0)
        (x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0)
        (x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0)
        Если все одного знака, то лежит
         */

        if (degenerateTriangleCheck(triangle)) {
            throw new Exception("Degenerate triangle");
        }

        double x0 = point.getX();
        double y0 = point.getY();
        double x1 = triangle.p1.getX();
        double y1 = triangle.p1.getY();
        double x2 = triangle.p2.getX();
        double y2 = triangle.p2.getY();
        double x3 = triangle.p3.getX();
        double y3 = triangle.p3.getY();

        boolean AP, BP, CP;

        AP = (((x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0)) > 0);
        BP = (((x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0)) > 0);
        CP = (((x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0)) > 0);

        return AP == BP && BP == CP;
    }

    private static boolean degenerateTriangleCheck(Triangle triangle) throws Exception {
        double x1 = triangle.p1.getX();
        double y1 = triangle.p1.getY();
        double x2 = triangle.p2.getX();
        double y2 = triangle.p2.getY();
        double x3 = triangle.p3.getX();
        double y3 = triangle.p3.getY();

        double AB = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double BC = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double AC = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        double largestEdge = Math.max(Math.max(AB, BC), Math.max(BC, AC));

        double halfPerimeter = Perimeter(triangle) / 2;

        return Math.abs(largestEdge - halfPerimeter) < 1e-9;
    }

}
