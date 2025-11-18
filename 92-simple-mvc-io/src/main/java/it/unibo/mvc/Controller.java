package it.unibo.mvc;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String DEFAULT_PATH = System.getProperty("user.home") +
            File.separator +
            "output.txt";

    private File currentFile = new File(DEFAULT_PATH);

    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public String getPath() {
        return currentFile.getAbsolutePath();
    }

    public void saveOnFile(final String toSave) throws FileNotFoundException, IOException {
        try (
                final DataOutputStream writer = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(currentFile)))) {
            writer.writeUTF(toSave);
        }
    }
}
