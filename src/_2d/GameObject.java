package _2d;

public abstract class GameObject {
    Transform transform;
    public GameObject(){
        transform=new Transform();
    }

    public abstract void start();
    public abstract void update();
}