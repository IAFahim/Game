package _3d;

import java.awt.geom.Point2D;

public class Position extends Point2D implements Cloneable {

    private Point2D rotation2D;
    private double z;

    Position() {
        rotation2D = new Point2D.Double();
        z = 0;
    }

    @Override
    public String toString() {
        return "_3d.Position{" +
                "x=" + rotation2D.getX() +
                ", y=" + rotation2D.getX() +
                ", z=" + z +
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

    public double getZ() {
        return z;
    }

    @Override
    public void setLocation(double x, double y) {
        this.rotation2D.setLocation(x, y);
        z = 0;
    }

    public void setLocation(double x, double y, double z) {
        setLocation(x, y);
        this.z = z;
    }

    public Object clone() {
        return this.clone();
    }

}
