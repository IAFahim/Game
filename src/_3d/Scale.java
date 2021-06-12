package _3d;

public class Scale implements Cloneable {
    private double x, y, z;

    Scale() {
        x = 0;
        y = 0;
        z = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
                ", z=" + z +
                '}';
    }
}
