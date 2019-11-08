package com.iec.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import com.iec.dao.UserCustomerDetailDao;
import com.iec.dao.UserProfileDao;
import com.iec.dao.impl.UserCustomerDetailDaoImpl;
import com.iec.entity.UserProfile;

import java.awt.Font;

import javax.management.modelmbean.ModelMBean;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Admin extends JFrame {
	UserCustomerDetailDao customerDetailDao = new UserCustomerDetailDaoImpl();
	private JTable table;
	JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 499);
		// setBounds(100, 100, 840, 397);

		getContentPane().setLayout(null);

		JButton btnDisplayCustomer = new JButton("DISPLAY CUSTOMER ");
		btnDisplayCustomer.setBackground(Color.WHITE);
		btnDisplayCustomer.setForeground(new Color(0, 0, 205));
		btnDisplayCustomer.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\details11.jpg"));
		btnDisplayCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// code
				// System.out.println("Test");
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayCustomerList frame = new DisplayCustomerList();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDisplayCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDisplayCustomer.setBounds(234, 223, 221, 52);
		getContentPane().add(btnDisplayCustomer);

		JButton btnDeleteProduct = new JButton("DELETE PRODUCT");
		btnDeleteProduct.setBackground(Color.WHITE);
		btnDeleteProduct.setForeground(Color.RED);
		btnDeleteProduct.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Copy3.png"));
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
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
		});
		btnDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteProduct.setBounds(685, 363, 221, 52);
		getContentPane().add(btnDeleteProduct);

		JButton btnCustomer = new JButton("DELETE CUSTOMER");
		btnCustomer.setBackground(Color.WHITE);
		btnCustomer.setForeground(Color.RED);
		btnCustomer.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Copy3.png"));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayCustomerList frame = new DisplayCustomerList();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCustomer.setBounds(246, 363, 221, 52);
		getContentPane().add(btnCustomer);

		JButton btnUpdateData = new JButton("UPDATE DATA");
		btnUpdateData.setBackground(Color.WHITE);
		btnUpdateData.setForeground(Color.BLUE);
		btnUpdateData.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Log Out - Copy5.png"));
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UpdateProduct frame = new UpdateProduct();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
				
			}
		});
		btnUpdateData.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateData.setBounds(486, 223, 189, 52);
		getContentPane().add(btnUpdateData);

		JButton btnAddStaffs = new JButton("ADD STAFFS");
		btnAddStaffs.setBackground(Color.WHITE);
		btnAddStaffs.setForeground(Color.BLUE);
		btnAddStaffs.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Copy4.png"));
		btnAddStaffs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnAddStaffs.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddStaffs.setBounds(10, 223, 183, 52);
		getContentPane().add(btnAddStaffs);

		JButton btnDeleteStaffs = new JButton("DELETE STAFFS");
		btnDeleteStaffs.setForeground(Color.RED);
		btnDeleteStaffs.setBackground(Color.WHITE);
		btnDeleteStaffs.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Copy3.png"));
		btnDeleteStaffs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayCustomerList frame = new DisplayCustomerList();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDeleteStaffs.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteStaffs.setBounds(10, 363, 186, 52);
		getContentPane().add(btnDeleteStaffs);

		JButton btnLogOut = new JButton("");
		btnLogOut.setBackground(Color.LIGHT_GRAY);
		btnLogOut.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\logout-button-blue-hi13.png"));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin admin = new Admin();
				dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogOut.setBounds(736, 22, 133, 46);
		getContentPane().add(btnLogOut);

		JLabel label = new JLabel("");
		label.setBounds(326, 203, 46, 14);
		getContentPane().add(label);

		JButton button = new JButton(" UPLOAD PRODUCT");
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLUE);
		button.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Stock Index Up - Copy9.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Product frame = new Product();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(685, 223, 221, 52);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\download (1) - Copy6.jpg"));
		lblNewLabel.setBounds(0, 0, 100, 100);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(-6, -16, 1212, 822);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(6, 16, 1200, 799);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\the-carpet-cellar (1)15.jpg"));

	}
}
