package Sepeda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SepedaGUI extends JFrame implements ActionListener {
    private JTextField gearField, speedField;
    private JButton increaseGearButton, increaseSpeedButton;
    private Sepeda sepeda;

    public SepedaGUI() {
        // Initialize Sepeda object
        sepeda = new Sepeda();

        // Create JFrame
        setTitle("Sepeda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);

        // Create components
        JLabel gearLabel = new JLabel("Gir:");
        gearField = new JTextField(10);
        gearField.setEditable(false);
        gearField.setText(Integer.toString(sepeda.getGir()));
        JLabel speedLabel = new JLabel("Kecepatan:");
        speedField = new JTextField(10);
        speedField.setEditable(false);
        speedField.setText(Integer.toString(sepeda.getKecepatan()));
        increaseGearButton = new JButton("Tambah Gir");
        increaseGearButton.addActionListener(this);
        increaseSpeedButton = new JButton("Tambah Kecepatan");
        increaseSpeedButton.addActionListener(this);

        // Add components to JFrame
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(gearLabel);
        panel.add(gearField);
        panel.add(speedLabel);
        panel.add(speedField);
        panel.add(increaseGearButton);
        panel.add(increaseSpeedButton);
        add(panel);

        // Display JFrame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == increaseGearButton) {
            sepeda.ubahGear(1); // Increase gear by 1
            gearField.setText(Integer.toString(sepeda.getGir()));
        } else if (e.getSource() == increaseSpeedButton) {
            sepeda.tambahKecepatan(5); // Increase speed by 5
            speedField.setText(Integer.toString(sepeda.getKecepatan()));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SepedaGUI();
            }
        });
    }
}

class Sepeda {
    private int kecepatan = 0;
    private int gir = 0;

    public void ubahGear(int pertambahanGir) {
        gir += pertambahanGir;
        System.out.println("Gir: " + gir);
    }

    public void tambahKecepatan(int pertambahanKecepatan) {
        kecepatan += pertambahanKecepatan;
        System.out.println("Kecepatan: " + kecepatan);
    }

    public int getGir() {
        return gir;
    }

    public int getKecepatan() {
        return kecepatan;
    }
}
