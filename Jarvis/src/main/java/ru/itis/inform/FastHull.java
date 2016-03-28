package ru.itis.inform;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by acacuce on 22.03.16.
 */
public class FastHull {
    ArrayList<Point> points;
    ArrayList<Point> hull;

    public FastHull(ArrayList<Point> points) {
        this.points = points;
        this.hull = new ArrayList<Point>();
    }

    private void quickHull () {
        if (points.size() <= 3) {
            hull = points;
            return;
        }
        int leftPosition = 0, rightPosition = 0;
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getX() < points.get(leftPosition).getX()){
                leftPosition = i;
            }else {
                if (points.get(i).getX() > points.get(rightPosition).getX()) {
                    rightPosition = i;
                }
            }
        }
        Line line = new Line(points.get(leftPosition), points.get(rightPosition));
        ArrayList<Integer> indexOfPointsAboveLine = new ArrayList<Integer>();
        ArrayList<Integer> indexOfPointsBellowLine = new ArrayList<Integer>();
        for (int i = 0; i < points.size(); i++) {
            if (i != leftPosition && i != rightPosition) {
                Point current = points.get(i);
                if (line.isLeft(current))
                    indexOfPointsAboveLine.add(i);
                else if (line.isRight(current))
                        indexOfPointsBellowLine.add(i);

            }
        }
        quickHull(leftPosition, rightPosition, indexOfPointsAboveLine, line);
        quickHull(rightPosition, leftPosition, indexOfPointsBellowLine, line);

    }

    private void quickHull (int leftPosition, int rightPosition, ArrayList<Integer> indexOfPoints, Line line) {
        if (indexOfPoints.size() == 0) {
            hull.add(points.get(rightPosition));
            return;
        }
        int topPosition = indexOfPoints.get(0);
        Line topLine = new Line(points.get(leftPosition), points.get(topPosition));
        double maxDist = line.distance(points.get(topPosition));
        for (int i = 1; i < indexOfPoints.size(); i++) {
            if (indexOfPoints.get(i) != leftPosition && indexOfPoints.get(i) != rightPosition) {
                double currentDistance = line.distance(points.get(indexOfPoints.get(i)));
                if (currentDistance == maxDist) {
                    if (topLine.isLeft(points.get(indexOfPoints.get(i)))) {
                        topPosition = indexOfPoints.get(i);
                        topLine = new Line(points.get(leftPosition), points.get(topPosition));
                    }
                } else if (maxDist < currentDistance) {
                    maxDist = currentDistance;
                    topPosition = indexOfPoints.get(i);
                    topLine = new Line(points.get(leftPosition), points.get(topPosition));

                }
            }
        }

        Line leftTopLine = new Line(points.get(leftPosition), points.get(topPosition));
        ArrayList<Integer> pointsAboveLineForLeftTop = getIndexOfPointsAboveTheLine(leftTopLine, indexOfPoints);
        quickHull(leftPosition, topPosition, pointsAboveLineForLeftTop, leftTopLine);
        Line topRightLine = new Line(points.get(topPosition), points.get(rightPosition));
        ArrayList<Integer> pointsAboveLineForTopRight = getIndexOfPointsAboveTheLine(topRightLine, indexOfPoints);
        quickHull(topPosition, rightPosition, pointsAboveLineForTopRight, topRightLine);

    }

    private ArrayList<Integer> getIndexOfPointsAboveTheLine (Line line, ArrayList<Integer> indexOfPoints) {
        ArrayList<Integer> indexOfPointsAboveTheLine = new ArrayList<Integer>();
        for (int i = 0; i < indexOfPoints.size(); i++) {
            Point current = points.get(i);
            if (line.isLeft(current)) {
                indexOfPointsAboveTheLine.add(i);
            }
        }
        return indexOfPointsAboveTheLine;
    }

    public void buildHull () {
        quickHull();
    }

    public ArrayList<Point> getHull() {
        return hull;
    }
}
