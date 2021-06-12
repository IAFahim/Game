package _3d;

public class Transform {
    Position position;
    Rotation rotation;
    Scale scale;

    public Transform() {
        position=new Position();
        rotation=new Rotation();
        scale=new Scale();
    }
}