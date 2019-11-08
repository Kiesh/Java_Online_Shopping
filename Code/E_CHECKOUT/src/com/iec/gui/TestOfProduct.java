package com.iec.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import com.iec.dao.UserProductDao;
import com.iec.dao.impl.UserProductDaoImpl;
import com.iec.entity.UserProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;

public class TestOfProduct extends JFrame {
	UserProductDao dao = new UserProductDaoImpl();
	private JPanel contentPane;
	private JLabel lblNewLabel[];
	private JLabel lblProductname[];
	private JLabel lblProductprice[];
	private JLabel lblImage[];
	private JTextField textFieldId[];
	private JTextField textFieldName[];
	private JTextField textFieldPrice[];
	private JLabel lblPImage[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestOfProduct frame = new TestOfProduct();
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
	public TestOfProduct() {
		setTitle("Test");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 497);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setPreferredSize(new Dimension(400, 400));

		//JButton btnNewButton = new JButton("DISPLAY");

	//	btnNewButton.addActionListener(new ActionListener() {

		//	public void actionPerformed(ActionEvent arg0) 
		//	{
				ArrayList<UserProduct> list = dao.getAll();
				int size = list.size();

				int x = 10;
				int y = 99;
				int u = 324;
				int v = 324;
				int lx = 16, ly = 12;
				int tx = 123, ty = 12;
				
				//bjhj
				//JScrollPane scrollPane = new JScrollPane();
				//scrollPane.setBounds(10, 0, 836, 444);
				//contentPane.add(scrollPane);
				
				
				//scrollPane.setViewportView(panel);
				
	JPanel panel[] = new JPanel[size];
				
				
				
				
				JLabel lblId[] = new JLabel[size];
				JLabel lblName[] = new JLabel[size];
				textFieldId = new JTextField[size];
				textFieldName = new JTextField[size];
				JLabel lblPrice[] = new JLabel[size];
				textFieldPrice = new JTextField[size];
				lblPImage = new JLabel[size];
				for (int i = 0; i < size; i++) {
					UserProduct product = new UserProduct();
					product.setId(list.get(i).getId());
					product.setName(list.get(i).getName());
					//System.out.println("getName():" + list.get(i).getName());
					product.setPrice(list.get(i).getPrice());
					product.setImage(list.get(i).getImage());
					panel[i] = new JPanel();
					panel[i].setBorder(new LineBorder(new Color(0, 0, 0)));
					panel[i].setBounds(x, y, u, v);
					// x=x+330;
					y = y + 300;
					contentPane.add(panel[i]);
					panel[i].setLayout(null);

					lblId[i] = new JLabel("ProductId");
					lblId[i].setBounds(lx, ly, 97, 19);
					panel[i].add(lblId[i]);
					lblId[i].setFont(new Font("Tahoma", Font.BOLD, 15));

					textFieldId[i] = new JTextField();
					textFieldId[i].setBounds(tx, ty, 191, 19);
					panel[i].add(textFieldId[i]);
					textFieldId[i].setColumns(10);
					textFieldId[i].setText(product.getId());

					lblName[i] = new JLabel("ProductName");
					lblName[i].setBounds(16, 41, 113, 19);
					panel[i].add(lblName[i]);
					lblName[i].setFont(new Font("Tahoma", Font.BOLD, 15));

					textFieldName[i] = new JTextField();
					textFieldName[i].setBounds(123, 42, 191, 19);
					panel[i].add(textFieldName[i]);
					textFieldName[i].setColumns(10);
					textFieldName[i].setText(product.getName());

					lblPrice[i] = new JLabel("ProductPrice");
					lblPrice[i].setBounds(16, 71, 97, 19);
					panel[i].add(lblPrice[i]);
					lblPrice[i].setFont(new Font("Tahoma", Font.BOLD, 15));

					textFieldPrice[i] = new JTextField();
					
					textFieldPrice[i].setBounds(123, 72, 191, 19);
					panel[i].add(textFieldPrice[i]);
					textFieldPrice[i].setColumns(10);
					textFieldPrice[i].setText(product.getPrice() + "");

					lblPImage[i] = new JLabel("");
					lblPImage[i].setBounds(10, 101, 304, 211);
					panel[i].add(lblPImage[i]);
					lblPImage[i].setBorder(new LineBorder(new Color(0, 0, 0)));
					lblPImage[i].setFont(new Font("Tahoma", Font.BOLD, 15));

					byte[] img = product.getImage();
					ImageIcon icon = new ImageIcon(img);
					lblPImage[i].setIcon(icon);
				
//
			
					

				}
				
				

			//}

		//});
	//	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		//btnNewButton.setBounds(22, 11, 144, 37);
		//contentPane.add(btnNewButton);

		JButton btnAddOnCart = new JButton("ADD ON CART");
		btnAddOnCart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddOnCart.setBounds(491, 11, 144, 37);
		contentPane.add(btnAddOnCart);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestOfProduct testOfProduct = new TestOfProduct();
				dispose();
			}
		});
		
		

		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(788, 11, 144, 37);
		contentPane.add(btnLogout);
		
		
		
		

	}
}
