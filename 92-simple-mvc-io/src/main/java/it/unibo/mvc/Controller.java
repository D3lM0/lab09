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

public final class Controller {
    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";

    private File currentFile = new File(DEFAULT_PATH);

    /**
     * Set the currentFile.
     * 
     * @param currentFile the file to set as current
     */
    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * @return currentFile
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * @return the path of the currentFile
     */
    public String getPath() {
        return currentFile.getAbsolutePath();
    }

    /**
     * Save the string on the currentFile.
     * 
     * @param toSave the string to save on file.
     * @throws FileNotFoundException if found is not existing.
     * @throws IOException           if something goes wrong during writing on file.
     */
    public void saveOnFile(final String toSave) throws FileNotFoundException, IOException {
        try (
                DataOutputStream writer = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(currentFile)))) {
            writer.writeUTF(toSave);
        }
    }
}
