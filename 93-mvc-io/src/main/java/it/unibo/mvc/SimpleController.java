package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString;
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNextStringToPrint(final String toPrint) {
        if (toPrint == null) {
            throw new NullPointerException("Input string shouldn't be null"); // NOPMD
        }

        this.nextString = toPrint;
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    @Override
    public List<String> getHistoryOfPrintedStrings() {
        return Collections.unmodifiableList(this.history);
    }

    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("String to print is unset");
        }

        // CHECKSTYLE: SystemPrintln OFF
        System.out.println(this.nextString); // NOPMD the method should print the string on console
        this.history.add(this.nextString);
    }

}
