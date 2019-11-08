package com.iec.gui;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iec.entity.UserCrediantls;
import com.iec.service.UserService;

import com.iec.serviceDao.impl.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LogInPage extends JFrame {
	// protected static final Object USERTYPE = null;

	private UserService userService = new UserServiceImpl();
	// to call from the userService into the Interface

	private JPanel contentPane;
	private JTextField textUserId;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage frame = new LogInPage();
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
	public LogInPage() {
		setForeground(new Color(153, 255, 255));
		setFont(new Font("Dialog", Font.BOLD, 30));
		setTitle("LogInPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 478);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("USERID");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(243, 124, 95, 30);
		contentPane.add(lblNewLabel);

		textUserId = new JTextField();
		textUserId.setForeground(Color.BLUE);
		textUserId.setBounds(443, 127, 193, 28);
		contentPane.add(textUserId);
		textUserId.setColumns(10);

		lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(243, 204, 113, 25);
		contentPane.add(lblNewLabel_1);

		passwordPassword = new JPasswordField();
		passwordPassword.setForeground(Color.BLUE);
		passwordPassword.setBounds(443, 203, 193, 30);
		contentPane.add(passwordPassword);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Login (2).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userId = textUserId.getText();
				String password = passwordPassword.getText();
				System.out.print(userId + "_" + password);

				UserCrediantls user = new UserCrediantls(userId, password);
				boolean response = userService.loginStatus(user);
				// serviceDao ko loginstatus may call kiye

				if (response) {
					String USERTYPE = userService.userType(user);

					if (USERTYPE.equals("A")) {
						Admin admin = new Admin();
						admin.setVisible(true);

					} else if (USERTYPE.equals("S")) {

						Staffs staffs = new Staffs();
						staffs.setVisible(true);
					} else if (USERTYPE.equals("C")) {
						Customer customer = new Customer();
						customer.setVisible(true);
					} else if (USERTYPE.equals("FAIL")) {
						JOptionPane.showMessageDialog(contentPane, "UserId Or Password Incorrect");

					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "UserId Or Password Incorrect");

				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(279, 279, 128, 51);
		contentPane.add(btnNewButton);

		JButton button = new JButton("");
		button.setBackground(Color.BLUE);
		button.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\RegisterNow.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				// public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UserRegistration frame = new UserRegistration();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(539, 279, 113, 51);
		contentPane.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("E-CHECKOUT");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_2.setBounds(279, 11, 229, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Login2.png"));
		lblNewLabel_3.setBounds(10, 113, 144, 142);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\12.jpg"));
		lblNewLabel_4.setBounds(-148, -149, 1024, 768);
		contentPane.add(lblNewLabel_4);
	}
}
