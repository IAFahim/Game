import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    private Thread thread;

    public String title;
    public int width, height;
    private boolean running = false;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
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
        initializeDisplay();
        while (running) {
            update();
            render();
        }
        stop();
    }
}