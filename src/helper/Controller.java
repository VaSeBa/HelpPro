package helper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Controller {
    public static void main(String[] args) throws IOException {
        View view = new View();
        view.go();


    }
}