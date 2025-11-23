package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "File Chooser GUI";
    private static final int PROPORTION = 3;
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame(TITLE);

    /**
     * SimpleGUIWithFileChooser constructor.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        final JPanel browseFilePanel = new JPanel();
        browseFilePanel.setLayout(new BorderLayout());

        final JTextArea text = new JTextArea();
        canvas.add(text);

        final JTextField pathField = new JTextField(controller.getPath());
        pathField.setEditable(false);
        final JButton browse = new JButton("Browse...");

        final JButton save = new JButton("Save");

        browseFilePanel.add(pathField, BorderLayout.CENTER);
        browseFilePanel.add(browse, BorderLayout.LINE_END);

        canvas.add(browseFilePanel, BorderLayout.NORTH);
        canvas.add(save, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    final File chosenFile = fileChooser.getSelectedFile();
                    controller.setCurrentFile(chosenFile);
                    pathField.setText(controller.getPath());
                } else if (fileChooser.showSaveDialog(frame) == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Errore nella selezione del file");
                }
            }

        });

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    controller.saveOnFile(text.getText());
                } catch (final IOException t) {
                    t.printStackTrace(); // NOPMD
                }
            }

        });

    }

    /** Starts the GUI. */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.pack();
    }

    /**
     * Main method.
     * 
     * @param args arguments passed to main method.
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }

}
