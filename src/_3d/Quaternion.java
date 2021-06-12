package _3d;

import static java.lang.Math.*;

public class Quaternion implements Cloneable {

    private double x, y, z, w;

    Quaternion() {
        x = 0;
        y = 0;
        z = 0;
        w = 1;
    }

    Quaternion(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    static Quaternion toQuaternion(double x, double y, double z) {
        double cy = cos(z * 0.5);
        double sy = sin(z * 0.5);
        double cp = cos(y * 0.5);
        double sp = sin(y * 0.5);
        double cr = cos(x * 0.5);
        double sr = sin(x * 0.5);

        Quaternion q = new Quaternion();
        q.w = cr * cp * cy + sr * sp * sy;
        q.x = sr * cp * cy - cr * sp * sy;
        q.y = cr * sp * cy + sr * cp * sy;
        q.z = cr * cp * sy - sr * sp * cy;

        return q;
    }

    Quaternion Identity() {
        return new Quaternion();
    }


    public static Quaternion add(Quaternion quaternion1, Quaternion quaternion2) {
        Quaternion quaternion = new Quaternion();
        quaternion.x = quaternion1.x + quaternion2.x;
        quaternion.y = quaternion1.y + quaternion2.y;
        quaternion.z = quaternion1.z + quaternion2.z;
        quaternion.w = quaternion1.w + quaternion2.w;
        return quaternion;
    }

    public static Quaternion concatenate(Quaternion value1, Quaternion value2) {
        Quaternion quaternion = new Quaternion();
        double x = value2.x;
        double y = value2.y;
        double z = value2.z;
        double w = value2.w;
        double num4 = value1.x;
        double num3 = value1.y;
        double num2 = value1.z;
        double num = value1.w;
        double num12 = (y * num2) - (z * num3);
        double num11 = (z * num4) - (x * num2);
        double num10 = (x * num3) - (y * num4);
        double num9 = ((x * num4) + (y * num3)) + (z * num2);
        quaternion.x = ((x * num) + (num4 * w)) + num12;
        quaternion.y = ((y * num) + (num3 * w)) + num11;
        quaternion.z = ((z * num) + (num2 * w)) + num10;
        quaternion.w = (w * num) - num9;
        return quaternion;

    }

    public static Quaternion divide(Quaternion quaternion1, Quaternion quaternion2) {
        Quaternion quaternion = new Quaternion();
        double x = quaternion1.x;
        double y = quaternion1.y;
        double z = quaternion1.z;
        double w = quaternion1.w;
        double num14 = (((quaternion2.x * quaternion2.x) + (quaternion2.y * quaternion2.y)) + (quaternion2.z * quaternion2.z)) + (quaternion2.w * quaternion2.w);
        double num5 = 1 / num14;
        double num4 = -quaternion2.x * num5;
        double num3 = -quaternion2.y * num5;
        double num2 = -quaternion2.z * num5;
        double num = quaternion2.w * num5;
        double num13 = (y * num2) - (z * num3);
        double num12 = (z * num4) - (x * num2);
        double num11 = (x * num3) - (y * num4);
        double num10 = ((x * num4) + (y * num3)) + (z * num2);
        quaternion.x = ((x * num) + (num4 * w)) + num13;
        quaternion.y = ((y * num) + (num3 * w)) + num12;
        quaternion.z = ((z * num) + (num2 * w)) + num11;
        quaternion.w = (w * num) - num10;
        return quaternion;

    }


    public void conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public static Quaternion conjugate(Quaternion value) {
        Quaternion quaternion = new Quaternion();
        quaternion.x = -value.x;
        quaternion.y = -value.y;
        quaternion.z = -value.z;
        quaternion.w = value.w;
        return quaternion;
    }

    public static Quaternion inverse(Quaternion quaternion) {
        Quaternion quaternion2 = new Quaternion();
        double num2 = (((quaternion.x * quaternion.x) + (quaternion.y * quaternion.y)) + (quaternion.z * quaternion.z)) + (quaternion.w * quaternion.w);
        double num = 1.0 / num2;
        quaternion2.x = -quaternion.x * num;
        quaternion2.y = -quaternion.y * num;
        quaternion2.z = -quaternion.z * num;
        quaternion2.w = quaternion.w * num;
        return quaternion2;

    }

    public double lengthSquared() {
        return ((((this.x * this.x) + (this.y * this.y)) + (this.z * this.z)) + (this.w * this.w));
    }

    public double length() {
        double num = (((this.x * this.x) + (this.y * this.y)) + (this.z * this.z)) + (this.w * this.w);
        return sqrt(num);
    }

    public static Quaternion lerp(Quaternion quaternion1, Quaternion quaternion2, double amount) {
        double num2 = 1.0 - amount;
        Quaternion quaternion = new Quaternion();
        double num5 = (((quaternion1.x * quaternion2.x) + (quaternion1.y * quaternion2.y)) + (quaternion1.z * quaternion2.z)) + (quaternion1.w * quaternion2.w);
        if (num5 >= 0.0) {
            quaternion.x = (num2 * quaternion1.x) + (amount * quaternion2.x);
            quaternion.y = (num2 * quaternion1.y) + (amount * quaternion2.y);
            quaternion.z = (num2 * quaternion1.z) + (amount * quaternion2.z);
            quaternion.w = (num2 * quaternion1.w) + (amount * quaternion2.w);
        } else {
            quaternion.x = (num2 * quaternion1.x) - (amount * quaternion2.x);
            quaternion.y = (num2 * quaternion1.y) - (amount * quaternion2.y);
            quaternion.z = (num2 * quaternion1.z) - (amount * quaternion2.z);
            quaternion.w = (num2 * quaternion1.w) - (amount * quaternion2.w);
        }
        double num4 = (((quaternion.x * quaternion.x) + (quaternion.y * quaternion.y)) + (quaternion.z * quaternion.z)) + (quaternion.w * quaternion.w);
        double num3 = 1.0 / sqrt(num4);
        quaternion.x *= num3;
        quaternion.y *= num3;
        quaternion.z *= num3;
        quaternion.w *= num3;
        return quaternion;
    }

    public static Quaternion slerp(Quaternion quaternion1, Quaternion quaternion2, double amount) {
        double num2;
        double num3;
        Quaternion quaternion = new Quaternion();
        double num4 = (((quaternion1.x * quaternion2.x) + (quaternion1.y * quaternion2.y)) + (quaternion1.z * quaternion2.z)) + (quaternion1.w * quaternion2.w);
        boolean flag = false;
        if (num4 < 0) {
            flag = true;
            num4 = -num4;
        }
        if (num4 > 0.999999) {
            num3 = 1.0 - amount;
            num2 = flag ? -amount : amount;
        } else {
            double num5 = acos(num4);
            double num6 = 1.0 / sin(num5);
            num3 = sin((1.0 - amount) * num5) * num6;
            num2 = flag ? (-sin(amount * num5) * num6) : (sin(amount * num5) * num6);
        }
        quaternion.x = (num3 * quaternion1.x) + (num2 * quaternion2.x);
        quaternion.y = (num3 * quaternion1.y) + (num2 * quaternion2.y);
        quaternion.z = (num3 * quaternion1.z) + (num2 * quaternion2.z);
        quaternion.w = (num3 * quaternion1.w) + (num2 * quaternion2.w);
        return quaternion;
    }

    public static Quaternion mubtract(Quaternion quaternion1, Quaternion quaternion2) {
        Quaternion quaternion = new Quaternion();
        quaternion.x = quaternion1.x - quaternion2.x;
        quaternion.y = quaternion1.y - quaternion2.y;
        quaternion.z = quaternion1.z - quaternion2.z;
        quaternion.w = quaternion1.w - quaternion2.w;
        return quaternion;
    }

    public static Quaternion multiply(Quaternion quaternion1, Quaternion quaternion2) {
        Quaternion quaternion = new Quaternion();
        double x = quaternion1.x;
        double y = quaternion1.y;
        double z = quaternion1.z;
        double w = quaternion1.w;
        double num4 = quaternion2.x;
        double num3 = quaternion2.y;
        double num2 = quaternion2.z;
        double num = quaternion2.w;
        double num12 = (y * num2) - (z * num3);
        double num11 = (z * num4) - (x * num2);
        double num10 = (x * num3) - (y * num4);
        double num9 = ((x * num4) + (y * num3)) + (z * num2);
        quaternion.x = ((x * num) + (num4 * w)) + num12;
        quaternion.y = ((y * num) + (num3 * w)) + num11;
        quaternion.z = ((z * num) + (num2 * w)) + num10;
        quaternion.w = (w * num) - num9;
        return quaternion;
    }

    public static Quaternion multiply(Quaternion quaternion1, double scaleFactor) {
        Quaternion quaternion = new Quaternion();
        quaternion.x = quaternion1.x * scaleFactor;
        quaternion.y = quaternion1.y * scaleFactor;
        quaternion.z = quaternion1.z * scaleFactor;
        quaternion.w = quaternion1.w * scaleFactor;
        return quaternion;
    }


    public static Quaternion negate(Quaternion quaternion) {
        Quaternion quaternion2 = new Quaternion();
        quaternion2.x = -quaternion.x;
        quaternion2.y = -quaternion.y;
        quaternion2.z = -quaternion.z;
        quaternion2.w = -quaternion.w;
        return quaternion2;
    }

    public void normalize() {
        double num2 = (((this.x * this.x) + (this.y * this.y)) + (this.z * this.z)) + (this.w * this.w);
        double num = 1.0 / sqrt(num2);
        this.x *= num;
        this.y *= num;
        this.z *= num;
        this.w *= num;
    }

    public static Quaternion normalize(Quaternion quaternion) {
        Quaternion quaternion2 = new Quaternion();
        double num2 = (((quaternion.x * quaternion.x) + (quaternion.y * quaternion.y)) + (quaternion.z * quaternion.z)) + (quaternion.w * quaternion.w);
        double num = 1.0 / sqrt(num2);
        quaternion2.x = quaternion.x * num;
        quaternion2.y = quaternion.y * num;
        quaternion2.z = quaternion.z * num;
        quaternion2.w = quaternion.w * num;
        return quaternion2;
    }

    public boolean equals(Quaternion other) {
        return ((((this.x == other.x) && (this.y == other.y)) && (this.z == other.z)) && (this.w == other.w));
    }

    @Override
    public int hashCode() {
        return (int) (((this.x * 4 + this.y * 3) + this.z * 2) + this.w);
    }


    static double dot(Quaternion quaternion1, Quaternion quaternion2) {
        return ((((quaternion1.x * quaternion2.x) + (quaternion1.y * quaternion2.y)) + (quaternion1.z * quaternion2.z)) + (quaternion1.w * quaternion2.w));
    }


    static Rotation toEulerAngles(Quaternion q) {
        Rotation angles = new Rotation();

        double sinr_cosp = 2.0 * (q.w * q.x + q.y * q.z);
        double cosr_cosp = 1.0 - 2.0 * (q.x * q.x + q.y * q.y);
        angles.setX(atan2(sinr_cosp, cosr_cosp));

        double sinp = 2.0 * (q.w * q.y - q.z * q.x);
        if (abs(sinp) >= 1)
            angles.setY(copySign(PI / 2.0, sinp));
        else
            angles.setY(asin(sinp));

        double siny_cosp = 2.0 * (q.w * q.z + q.x * q.y);
        double cosy_cosp = 1.0 - 2.0 * (q.y * q.y + q.z * q.z);
        angles.setZ(atan2(siny_cosp, cosy_cosp));

        return angles;
    }


    static Rotation toEulerAngles(double x, double y, double z, double w) {
        Rotation angles = new Rotation();

        double sinr_cosp = 2.0 * (w * x + y * z);
        double cosr_cosp = 1 - 2.0 * (x * x + y * y);
        angles.setX(atan2(sinr_cosp, cosr_cosp));

        double sinp = 2.0 * (w * y - z * x);
        if (abs(sinp) >= 1)
            angles.setY(copySign(PI / 2.0, sinp));
        else
            angles.setY(asin(sinp));

        double siny_cosp = 2.0 * (w * z + x * y);
        double cosy_cosp = 1 - 2.0 * (y * y + z * z);
        angles.setZ(atan2(siny_cosp, cosy_cosp));

        return angles;
    }

    Rotation toEulerAngles() {
        Rotation angles = new Rotation();

        double sinr_cosp = 2.0 * (w * x + y * z);
        double cosr_cosp = 1 - 2.0 * (x * x + y * y);
        angles.setX(atan2(sinr_cosp, cosr_cosp));

        double sinp = 2.0 * (w * y - z * x);
        if (abs(sinp) >= 1)
            angles.setY(copySign(PI / 2, sinp));
        else
            angles.setY(asin(sinp));

        double siny_cosp = 2.0 * (w * z + x * y);
        double cosy_cosp = 1 - 2.0 * (y * y + z * z);
        angles.setZ(atan2(siny_cosp, cosy_cosp));

        return angles;
    }

    @Override
    public String toString() {
        return "_3d.Quaternion{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);

        }
    }

}