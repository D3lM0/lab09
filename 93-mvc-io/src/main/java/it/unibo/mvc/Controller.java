package it.unibo.mvc;

import java.util.List;

/**
 * Controller interface.
 */
public interface Controller {

    /**
     * Set the next string to print.
     * 
     * @param toPrint the string to set as next to print.
     * 
     * @throws NullPointerException if the string is null
     */
    void setNextStringToPrint(String toPrint);

    /**
     * @return the next string to print.
     */
    String getNextStringToPrint();

    /**
     * @return the list of printed string.
     */
    List<String> getHistoryOfPrintedStrings();

    /**
     * Print the string set as current.
     */
    void printCurrentString();

}
