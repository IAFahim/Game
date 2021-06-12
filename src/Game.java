import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    private Thread thread;

    public String title;
    public static int width, height;
    private boolean running = false;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    Game(String title, int width, int height) {
        this.title = title;
        Game.width = width;
        Game.height = height;
    }

    public synchronized void start() {
        if (running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initializeDisplay() {
        display = new Display(title, width, height);
    }

    private void update() {

    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();

        if (bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.fillRect(0, 0, width, height);

        bufferStrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        long start=System.currentTimeMillis();
        initializeDisplay();
        while (running) {
            update();
            render();
            System.out.println(System.currentTimeMillis()-start);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stop();
    }
}