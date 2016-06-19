package javasig.hello.java.closures.ch01.examples;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Checked exceptions in Functional Interfaces SAMTypes - not fun
 */
public class Example10 {
    public static void main(String[] args) throws InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        MyParser<LocalDate, ParseException> dateParser = parseable -> LocalDate.parse(parseable);

        try {
            System.out.println(dateParser.parse("2014-03-31").format(formatter));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        try {
            System.out.println(dateParser.parse("bad").format(formatter));
        } catch (DateTimeParseException | ParseException pe) {
            System.out.println("This is where the exception is caught");
            pe.printStackTrace();
        }

    }

    public static interface MyParser<T, X extends Exception> {
        public T parse(String parseable) throws X;
    }
}
