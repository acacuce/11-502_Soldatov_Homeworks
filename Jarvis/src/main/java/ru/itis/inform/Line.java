package ru.itis.inform;

/**
 * Created by acacuce on 22.03.16.
 */
public class Line {
    int a,b,c;

    public Line(Point firstPoint, Point secondPoint) {
        this.a = firstPoint.getY() - secondPoint.getY();
        this.b = secondPoint.getX() - firstPoint.getX();
        this.c = -(a*firstPoint.getX() + b*firstPoint.getY());
    }

    public double distance (Point point) {
        return (Math.abs(a*point.getX() + b*point.getY() + c)/Math.sqrt(a*a + b*b));
    }

    public boolean isLeft (Point point) {
        return a*point.getX() + b*point.getY() + c > 0;
    }

    public boolean isRight (Point point) {
        return a*point.getX() + b*point.getY() + c < 0;
    }
}
