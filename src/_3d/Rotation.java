package _3d;

public class Rotation implements Cloneable {

    private double x, y, z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setRotation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRotation(double x, double y, double z) {
        setRotation(x, y);
        this.z = z;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);

        }
    }

    @Override
    public String toString() {
        return "_3d.Rotation{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}