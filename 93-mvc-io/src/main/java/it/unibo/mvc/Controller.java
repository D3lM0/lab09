package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextStringToPrint(String toPrint);

    String getNextStringToPrint();

    List<String> getHistoryOfPrintedStrings();

    void printCurrentString();

}
