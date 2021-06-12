package _2d;

import java.awt.geom.Point2D;

public class Position extends Point2D implements Cloneable {

    private Point2D rotation2D;

    Position() {
        rotation2D = new Double();
    }

    @Override
    public String toString() {
        return "_3d.Position{" +
                "x=" + rotation2D.getX() +
                ", y=" + rotation2D.getX() +
                '}';
    }

    @Override
    public double getX() {
        return rotation2D.getX();
    }

    @Override
    public double getY() {
        return rotation2D.getY();
    }

    @Override
    public void setLocation(double x, double y) {
        this.rotation2D.setLocation(x, y);
    }

    public Object clone() {
        return this.clone();
    }

}
