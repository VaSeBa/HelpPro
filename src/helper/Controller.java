package helper;

/**
   Программа для кадровика -
   1. подсчет ежегодного отпуска за период
   2. подсчет периода между датами

   HR program -
   1.calculation of annual leave for a period
   2.counting the period between dates

   project from VaSeBa
   02/12/2020
 */

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