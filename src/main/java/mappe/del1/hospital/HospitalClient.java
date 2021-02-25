package mappe.del1.hospital;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class HospitalClient {
    public static void main(String[] args) {

        final Hospital hospital = new Hospital("NTNU Sentralsykehus");
        HospitalTestData.fillRegisterWithTestData(hospital);

        JFrame frame = new JFrame("Espen's Food Planner");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = (JPanel) frame.getContentPane();
        mainPanel.setLayout(null);

        JTextArea log = new JTextArea(5,30);
        log.setFocusable(false);
        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        JScrollPane windowScroll = new JScrollPane(log);
        windowScroll.setBounds(170,30,240,500);
        windowScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(),"Logg", 1, 3));

        JTextArea hospitalList= new JTextArea();
        hospitalList.setFocusable(false);
        hospitalList.setEditable(false);
        hospitalList.setText(hospital.toString());
        JScrollPane hospitalListScroll = new JScrollPane(hospitalList);
        hospitalListScroll.setBounds(420,30,350,500);
        hospitalListScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(),"Sykehuset", 1, 3));

        JButton removeEmployeeButton = new JButton ("Fjern ansatt");
        removeEmployeeButton.addActionListener(e -> {
            String socialSecurityNumber = JOptionPane.showInputDialog("Angi personnummeret til den ansatte som skal slettes:");
            try {
                for (Department department : hospital.getDepartments()) {
                    for (Employee employee : department.getEmployees()) {
                        if (employee.getSocialSecurityNumber().equals(socialSecurityNumber)) {
                            log.append("Fjernet " + employee.toString() + " fra sykehuset." );
                            department.remove(employee);
                            hospitalList.setText(hospital.toString());
                        }
                    }
                }
            } catch (Exception RemoveException) {
                log.append("Det finnes ingen ansatt med dette personnummeret på sykehuset.");
            }
        });

        JButton removePatientButton = new JButton ("Fjern pasient");
        removePatientButton.addActionListener(e -> {
            String socialSecurityNumber = JOptionPane.showInputDialog("Angi personnummeret til pasienten som skal slettes:");
            try {
                for (Department department : hospital.getDepartments()) {
                    for (Patient patient : department.getPatients()) {
                        if (patient.getSocialSecurityNumber().equals(socialSecurityNumber)) {
                            log.append("Fjernet " + patient.toString() + " fra sykehuset." );
                            department.remove(patient);
                            hospitalList.setText(hospital.toString());
                        }
                    }
                }
            } catch (Exception RemoveException) {
                log.append("Det finnes ingen pasient med dette personnummeret på sykehuset.");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeEmployeeButton);
        buttonPanel.add(removePatientButton);
        buttonPanel.setBounds(10,32,150,496);
        buttonPanel.setLayout(new GridLayout(0,1));


        mainPanel.add(buttonPanel);
        mainPanel.add(windowScroll);
        mainPanel.add(hospitalListScroll);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
}
