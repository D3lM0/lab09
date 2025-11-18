package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private static final String TITLE = "File Simple GUI";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);
    private Controller controller;

    // CHECKSTYLE: MissingJavadocMethod OFF
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        canvas.add(text);
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent event) {
                controller = new Controller();
                try {
                    controller.saveOnFile(text.getText());
                } catch (final IOException t) {
                    t.printStackTrace(); // NOPMD
                }
            }

        });
    }

    /* Starts the GUI */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.pack();
    }

    // CHECKSTYLE: MissingJavadocMethod OFF
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
