package com.inPowered;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.inpowered.ReaderApplication;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReaderApplicationTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  void readerApplicationShouldReturnFileNotFoundException() {
    String[] args = {"src/main/resources/file-not-existent.txt"};
    assertThrows(
        IOException.class,
        () -> ReaderApplication.main(args));
  }

  @Test
  void readerApplicationShouldReadFileWithSuccess() throws IOException, ParseException {
    String[] args = {"src/main/resources/AddressBook.txt"};
    ReaderApplication.main(args);

    assertTrue(outputStreamCaptor.toString().contains("3 males"));
    assertTrue(outputStreamCaptor.toString()
        .contains("The oldest person in the address book is Wes Jackson"));
    assertTrue(outputStreamCaptor.toString().contains("Bill is 2862 days older than Paul"));
  }

  @Test
  void calculateDateDifferenceInDaysShouldReturnRightResults() throws ParseException {
    Date firstDate = new SimpleDateFormat("dd/MM/yy").parse("05/11/2022");
    Date secondDate = new SimpleDateFormat("dd/MM/yy").parse("05/11/2021");

    assertEquals(365, ReaderApplication.calculateDateDifferenceInDays(firstDate, secondDate));
  }
}
