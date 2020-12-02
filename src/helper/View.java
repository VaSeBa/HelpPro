package helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class View extends JFrame {

    private static final JTextField FIRST_DATE = new JTextField(8);
    private static final JTextField SECOND_DATE = new JTextField(8);
    private final JButton BUTTON_DAY_OF_LEAVE = new JButton("Дней основного отпуска");
    private final JButton BUTTON_DAY_BETWEEN_DATE = new JButton("Период между датами");
    JLabel outputData;

    public void go() {
        JFrame frame = new JFrame("Личный помошник");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        outputData = new JLabel("Птичка вылетает тут!");


        BUTTON_DAY_BETWEEN_DATE.addActionListener(new CalcOfDay());
        BUTTON_DAY_OF_LEAVE.addActionListener(new CalcDayLeaving());
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.add(BUTTON_DAY_BETWEEN_DATE);
        buttonsPanel.add(BUTTON_DAY_OF_LEAVE);
        JPanel mainDataPanel = new JPanel();
        JPanel datePanel = new JPanel(new GridLayout(2,2));
        datePanel.add(new JLabel("Дата с :"));
        datePanel.add(FIRST_DATE);
        datePanel.add(new JLabel("Дата по :"));
        datePanel.add(SECOND_DATE);
        mainDataPanel.add(datePanel);
        mainDataPanel.add(outputData);

        frame.getContentPane().add(BorderLayout.CENTER, buttonsPanel);
        frame.getContentPane().add(BorderLayout.WEST, mainDataPanel);
        frame.setSize(550, 550);
        frame.setVisible(true);
    }


    private class CalcOfDay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate firstDate = LocalDate.parse(FIRST_DATE.getText(), formatter);
        LocalDate secondDate = LocalDate.parse(SECOND_DATE.getText(), formatter);
        Period period = Period.between(firstDate, secondDate);
        outputData.setText((period.getDays() + " д. " + period.getMonths() + " мес. " + period.getYears() + " л. "));

        }
    }

    private class CalcDayLeaving implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate firstDate = LocalDate.parse(FIRST_DATE.getText(), formatter);
            LocalDate secondDate = LocalDate.parse(SECOND_DATE.getText(), formatter);
            long day = ChronoUnit.DAYS.between(firstDate, secondDate);
            double dayLeaving = day / 30.4166666666d * 2.33333333333d;
            BigDecimal dayLeavingBig = new BigDecimal(dayLeaving);
            outputData.setText(dayLeavingBig.setScale(1, BigDecimal.ROUND_CEILING) + " д.");

        }
    }
}
