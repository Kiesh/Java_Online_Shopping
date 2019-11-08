package com.iec.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.iec.dao.UserProductDao;
import com.iec.dao.impl.UserProductDaoImpl;
import com.iec.entity.UserProduct;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UpdateProduct extends JFrame {
	UserProductDao dao = new UserProductDaoImpl();

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Create the frame.
	 */
	public UpdateProduct()
	{
		setFont(new Font("Dialog", Font.BOLD, 17));
		setTitle("UpdateProduct");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JButton btnDisplay = new JButton("DISPLAY");
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
		btnDisplay.setBounds(266, 11, 213, 40);
		contentPane.add(btnDisplay);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 53, 838, 178);
		contentPane.add(scrollPane);

		// table = new JTable();
		JPanel panel = new JPanel();
		scrollPane.setViewportView(table);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel model =new DefaultTableModel();
				String s=textFieldId.getText();
			    String s1=	textFieldName.getText();
			    Double  s2=	Double.parseDouble(textFieldPrice.getText());
				UserProduct u=new UserProduct(s,s1,s2,null);
				UserProductDao updao=new UserProductDaoImpl();
				updao.uploadProduct(u);
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(219, 345, 234, 48);
		contentPane.add(btnUpdate);

		JLabel lblProId = new JLabel("ProductID");
		lblProId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProId.setBounds(108, 244, 101, 14);
		contentPane.add(lblProId);

		textFieldId = new JTextField();
		textFieldId.setBounds(219, 242, 214, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JLabel lblProductname = new JLabel("ProductName");
		lblProductname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductname.setBounds(108, 277, 101, 14);
		contentPane.add(lblProductname);

		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(219, 273, 214, 20);
		contentPane.add(textFieldName);

		JLabel lblProductprice = new JLabel("ProductPrice");
		lblProductprice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductprice.setBounds(108, 302, 101, 14);
		contentPane.add(lblProductprice);

		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(219, 304, 214, 20);
		contentPane.add(textFieldPrice);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateProduct product=new UpdateProduct();
				dispose();
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(567, 345, 207, 48);
		contentPane.add(btnExit);

		
	}

}
