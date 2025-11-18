package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "File Chooser GUI";
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        final JPanel browseFilePanel = new JPanel();
        browseFilePanel.setLayout(new BorderLayout());

        final JTextField text = new JTextField();
        text.setEditable(false);
        final JButton browse = new JButton("Browse...");

        final JButton save = new JButton("Save");

        browseFilePanel.add(text, BorderLayout.CENTER);
        browseFilePanel.add(browse, BorderLayout.LINE_END);

        canvas.add(browseFilePanel, BorderLayout.NORTH);
        canvas.add(save, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String... args) {
        new SimpleGUIWithFileChooser().display();
    }

}
