package _2d;

public class Scale implements Cloneable {
    private double x, y;

    Scale() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    @Override
    public String toString() {
        return "_3d.Scale{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
