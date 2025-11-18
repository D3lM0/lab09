package it.unibo.mvc;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Application controller. Performs the I/O.
 */
//CHECKSTYLE: MissingJavadocMethod OFF
public final class Controller {
    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";

    private File currentFile = new File(DEFAULT_PATH);

    /* Set the currentFile */
    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }

    /* Return the currentFile */
    public File getCurrentFile() {
        return currentFile;
    }

    /* Return the path of the currentFile */
    public String getPath() {
        return currentFile.getAbsolutePath();
    }

    /* Save the string on the currentFile */
    public void saveOnFile(final String toSave) throws FileNotFoundException, IOException {
        try (
                DataOutputStream writer = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(currentFile)))) {
            writer.writeUTF(toSave);
        }
    }
}
