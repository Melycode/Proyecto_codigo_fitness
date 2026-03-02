package interfaz;

import javax.swing.*;
import java.awt.*;

public class CalculadoraIMC extends JFrame {

    public CalculadoraIMC() {
        setTitle("Calculadora IMC");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Calculadora IMC", SwingConstants.CENTER);
        titulo.setBounds(0, 10, 400, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo);

        JLabel labelNombre = new JLabel("Nombre cliente:");
        labelNombre.setBounds(30, 60, 80, 30);
        add(labelNombre);

        JTextField inputNombre = new JTextField();
        inputNombre.setBounds(120, 60, 200, 30);
        add(inputNombre);

        JLabel labelPeso = new JLabel("Peso (kg):");
        labelPeso.setBounds(30, 110, 80, 30);
        add(labelPeso);

        JTextField inputPeso = new JTextField();
        inputPeso.setBounds(120, 110, 200, 30);
        add(inputPeso);

        JLabel labelAltura = new JLabel("Altura (m):");
        labelAltura.setBounds(30, 160, 80, 30);
        add(labelAltura);

        JTextField inputAltura = new JTextField();
        inputAltura.setBounds(120, 160, 200, 30);
        add(inputAltura);


        JButton btnCalcular = new JButton("Calcular IMC");
        btnCalcular.setBounds(120, 220, 150, 40);
        add(btnCalcular);

        btnCalcular.addActionListener(e -> {
            try {
                double peso = Double.parseDouble(inputPeso.getText());
                double altura = Double.parseDouble(inputAltura.getText());
                double imc = peso / (altura * altura);
                String categoria;

                if (imc < 18.5) {
                    categoria = "Bajo peso";
                } else if (imc < 25) {
                    categoria = "Peso normal";
                } else if (imc < 30) {
                    categoria = "Sobrepeso";
                } else {
                    categoria = "Obesidad";
                }

                JOptionPane.showMessageDialog(this,
                        String.format("Nombre: %s\nIMC: %.2f\nCategoría: %s", inputNombre.getText(), imc, categoria),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Introduce valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
