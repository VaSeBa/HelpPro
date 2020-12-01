package helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class View extends JFrame{
    private static final JTextField FIRST_DATE = new JTextField(8);
    private static final JTextField SECOND_DATE = new JTextField(8);
    private final JButton BUTTON_DAY_OF_LEAVE = new JButton("Дней основного отпуска");
    private JTextField firstDate;
    private JTextField SecondDate;
    JLabel outputData;

    public void go() {
        JFrame frame = new JFrame("Личный помошник");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        outputData = new JLabel("Птичка вылетает тут!");
        BUTTON_DAY_OF_LEAVE.addActionListener(new CalcOfDay());
        JPanel buttonsPanel = new JPanel();

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
        frame.setSize(700, 900);
        frame.setVisible(true);
    }


    private class CalcOfDay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate firstDate = LocalDate.parse(FIRST_DATE.getText(), formatter);
        LocalDate secondDate = LocalDate.parse(SECOND_DATE.getText(), formatter);
        Period period = Period.between(firstDate, secondDate);
        outputData.setText(String.valueOf(period.getDays() + " дней " + period.getMonths() + " месяцев " + period.getYears() + " лет "));

        }
    }
}
