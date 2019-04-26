package com.dayanfreitas.View;

import com.dayanfreitas.SystemCheck.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View1 {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblBuscarPor;
	private JTextField textField_1;
	private JLabel lblResposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View1 window = new View1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInsiraOTexto = new JLabel("Insira o Texto:");
		lblInsiraOTexto.setBounds(45, 46, 100, 15);
		frame.getContentPane().add(lblInsiraOTexto);
		
		textField = new JTextField();
		textField.setBounds(45, 60, 200, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(45, 107, 100, 15);
		frame.getContentPane().add(lblBuscarPor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(45, 122, 200, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblResposta = new JLabel("Resposta:");
		lblResposta.setBounds(55, 190, 90, 20);
		frame.getContentPane().add(lblResposta);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(153, 102, 51));
	
		
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBounds(45, 150, 150, 25);
		frame.getContentPane().add(btnBuscar);
		
		final JLabel labelResposta = new JLabel("0");
		labelResposta.setBounds(130, 190, 200, 20);
		frame.getContentPane().add(labelResposta);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = textField.getText();
				String busca = textField_1.getText();
				
				Kmp b = new Kmp(busca,texto);
				
				//lblResposta.setText(texto);
				b.retornar();
				labelResposta.setText(b.getAchou());
			}
		});
	}
}
