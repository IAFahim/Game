import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame jFrame;
    private Canvas canvas;

    private final String title;
    private final int width, height;

    Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        run();
    }

    public void run() {
        jFrame = new JFrame(title);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        jFrame.add(canvas);
        jFrame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}