package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final String TITLE = "Simple GUI";
    private static final int PROPORTION = 3;
    private final SimpleController controller = new SimpleController();
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        final JTextField stringField = new JTextField();
        final JTextArea historyStringArea = new JTextArea();
        canvas.add(stringField, BorderLayout.NORTH);
        canvas.add(historyStringArea, BorderLayout.CENTER);

        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");

        buttonsPanel.add(print);
        buttonsPanel.add(showHistory);

        canvas.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Handlers */
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final String currentString = stringField.getText();
                controller.setNextStringToPrint(currentString);
                controller.printCurrentString();
            }

        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final List<String> history = controller.getHistoryOfPrintedStrings();
                historyStringArea.setText(history.toString());
            }

        });
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

    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
