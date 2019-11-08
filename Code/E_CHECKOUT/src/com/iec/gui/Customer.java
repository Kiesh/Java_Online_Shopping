package com.iec.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.iec.dao.UserProductDao;
import com.iec.dao.impl.UserProductDaoImpl;
import com.iec.entity.UserProduct;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Customer extends JFrame {
	UserProductDao dao = new UserProductDaoImpl();

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
		setTitle("PRODUCT_PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBackground(new Color(0, 255, 255));
		btnDisplay.setForeground(Color.BLUE);
		btnDisplay.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\images (1)10.jpg"));
		table = new JTable();
		//
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ProductId ", "ProductName", "ProductPrice", "Image" });

		table.setModel(model);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<UserProduct> list = dao.getAll();

				DefaultTableModel model1 = new DefaultTableModel();
				model1.setColumnIdentifiers(new String[] { "ProductId ", "ProductName", "ProductPrice", "Image" });
				for (UserProduct u : list) {

					model1.addRow(new Object[] { u.getId(), u.getName(), u.getPrice() });

				}
				table.setModel(model1);

			}
		});

		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplay.setBounds(10, 0, 168, 51);
		contentPane.add(btnDisplay);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 933, 404);
		contentPane.add(scrollPane);

		// table = new JTable();
		JPanel panel = new JPanel();
		scrollPane.setViewportView(table);

		JButton btnAddOnCart = new JButton("ADD ON CART");
		btnAddOnCart.setBackground(new Color(0, 255, 255));
		btnAddOnCart.setForeground(Color.BLUE);
		btnAddOnCart.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\Stock Index Down - Copy7.png"));
		btnAddOnCart.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddOnCart.setBounds(402, 0, 213, 51);
		contentPane.add(btnAddOnCart);

		JButton btnLogout = new JButton("");
		btnLogout.setBackground(new Color(0, 255, 255));
		btnLogout.setForeground(Color.BLUE);
		btnLogout.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\canstock12.jpg"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				dispose();

			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(831, 0, 112, 51);
		contentPane.add(btnLogout);
	}

}
