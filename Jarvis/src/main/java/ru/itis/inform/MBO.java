package ru.itis.inform;

import java.util.ArrayList;

/**
 * Created by acacuce on 18.03.16.
 */
public class MBO {
    ArrayList<Point> points;
    ArrayList<Point> MBO;


    public MBO(ArrayList<Point> points) {
        this.points = points;
        this.MBO = new ArrayList<Point>();
    }

    private boolean checkRotate(Point currentInMBO, Point iteration, Point right)
    {
        double val = (iteration.getY() - currentInMBO.getY()) * (right.getX() - iteration.getX()) - (iteration.getX() - currentInMBO.getX()) * (right.getY() - iteration.getY());
        if (val >= 0)
            return false;
        return true;
    }

    private int findLeftPoint () {
        int indexOfLeftPoint = 0;
        for (int i = 1; i < points.size(); i++) {
            if (points.get(0).getY() > points.get(i).getY()) {
                indexOfLeftPoint = i;
            }else
                if (points.get(indexOfLeftPoint).getY() == points.get(i).getY() && points.get(indexOfLeftPoint).getX() > points.get(i).getX()) {
                    indexOfLeftPoint = i;
                }
        }
        return indexOfLeftPoint;
    }

    public void buildMBO () {
        int right;
        int indexOfLeftPoint = findLeftPoint();
        int indexOfCurrentInMBO = indexOfLeftPoint;
        int length = points.size();
        do {
            right = (indexOfCurrentInMBO + 1) % length;
            for (int i = 0; i < length; i++) {
                if (checkRotate(points.get(indexOfCurrentInMBO), points.get(i), points.get(right))) {
                    right = i;
                }
            }
            MBO.add(points.get(right));
            indexOfCurrentInMBO = right;
        } while (points.get(indexOfCurrentInMBO) != points.get(indexOfLeftPoint));
    }

    public ArrayList<Point> getMBO() {
        return MBO;
    }
}
