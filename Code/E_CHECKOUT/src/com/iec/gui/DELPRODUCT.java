package com.iec.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;

public class DELPRODUCT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DELPRODUCT frame = new DELPRODUCT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DELPRODUCT() {
		setTitle("DeleteProduct");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setBackground(new Color(127, 255, 0));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Copy3.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DELPRODUCT delproduct=new DELPRODUCT();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(164, 390, 569, 59);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\30574093-Colorful-Fashion-Headscarf-fabrics-displayed-on-local-store-in-Indonesia-Thesae-are-the-headscarf-st-Stock-Photo.jpg"));
		lblNewLabel.setBounds(0, -12, 1300, 866);
		contentPane.add(lblNewLabel);
	}
}
