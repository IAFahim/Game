package _2d;

public class Rotation implements Cloneable {

    private double x, y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRotation(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public String toString() {
        return "_3d.Rotation{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}