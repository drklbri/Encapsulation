package ru.vsu.cs.shevchenko_daniil;

public class Tests {

    public static void AreaTest(Triangle triangle, double answer) throws Exception {
        if (TriangleMethods.Area(triangle) == answer){
            System.out.println("Area test was successful");
        } else {
            System.out.println("Area test wasn't successful");
        }
    }

    public static void PerimeterTest(Triangle triangle, double answer){
        if (TriangleMethods.Perimeter(triangle) == answer){
            System.out.println("Perimeter test was successful");
        } else {
            System.out.println("Perimeter test wasn't successful");
        }
    }

    public static void PointInTriangleTest(Triangle triangle, Point point, boolean answer) throws Exception {
        if (TriangleMethods.IsPointInTriangle(triangle, point) == answer){
            System.out.println("Point in triangle test was successful");
        } else {
            System.out.println("Point in triangle test wasn't successful");
        }
    }

    public static void test() throws Exception {
        System.out.println("Тест для обычного треугольника");
        Triangle testTriangle = TriangleMethods.CoordIntoTriangle(0, 0, 0, 3, 4, 0);
        //Пифагоров треугольник
        Point testPoint1 = new Point(0, 3);
        //Пограничная точка для пифагорова треугольника
        Point testPoint2 = new Point(1, 1);
        //Точка в пифагоровом треугольнике
        Point testPoint3 = new Point(2.5, 2.5);
        //Точка вне пифагорова треугольника
        AreaTest(testTriangle,6);
        PerimeterTest(testTriangle, 12);
        PointInTriangleTest(testTriangle,testPoint1,true);
        PointInTriangleTest(testTriangle,testPoint2,true);
        PointInTriangleTest(testTriangle,testPoint3,false);
        System.out.println();

        System.out.println("Тест для обычного треугольника");
        Triangle testTriangle2 = TriangleMethods.CoordIntoTriangle(0, 0, 0, 0, 0, 0);
        //Точка вместо треугольника
        AreaTest(testTriangle2,0);
        PerimeterTest(testTriangle2, 0);
        PointInTriangleTest(testTriangle2,testPoint1,false);

    }

}
