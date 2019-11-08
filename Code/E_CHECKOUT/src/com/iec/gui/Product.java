package com.iec.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iec.dao.UserProductDao;
import com.iec.dao.impl.UserProductDaoImpl;
import com.iec.entity.UserProduct;
import com.iec.filefilter.FileTypeFilter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Product extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JLabel lblProductImage;
	private JFileChooser jFileChooser;
	// private JLabel lblNewLabel_1;
	private JLabel lblPhoto;
	private File file;
	private JTextField textProductId;
	private JButton btnExit;
	private JTextField textPrice;
	private JLabel lblPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	// for image in database
	// set byte[] in upload button se hai
	//
	//
	private byte[] ConvertFile(String fileName) {
		FileInputStream fileInputStream = null;
		File file = new File(fileName);
		byte[] bFile = new byte[(int) file.length()];
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			bFile = null;
		}
		return bFile;
	}

	// uptohere
	/**
	 * Create the frame.
	 */
	public Product() {
		setTitle("CustomerProductList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 63, 127, 19);
		contentPane.add(lblNewLabel);

		textName = new JTextField();
		textName.setBounds(147, 64, 362, 20);
		contentPane.add(textName);
		textName.setColumns(10);

		JButton btnBrowse = new JButton("BROWSE");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("Please select the image");
				jFileChooser.setMultiSelectionEnabled(false);
				// for the FileTypeFilter I made One cLas of Filter
				// where is declare directory
				// in package com.iec.filefilter
				jFileChooser.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
				//
				jFileChooser.setFileFilter(new FileTypeFilter(".png", "PNG"));

				// jFileChooser.setFileFilter(new FileTypeFilter(extension,
				// description));

				jFileChooser.setMultiSelectionEnabled(false);
				//
				int result = jFileChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					file = jFileChooser.getSelectedFile();
					lblPhoto.setIcon(new ImageIcon(file.getAbsolutePath()));
				}
			}
		});
		btnBrowse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBrowse.setBounds(147, 142, 362, 35);
		contentPane.add(btnBrowse);

		JButton btnUpload = new JButton("UPLOAD");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserProductDao dao = new UserProductDaoImpl();
					// UserProduct userProduct = new UserProduct();
					UserProduct product = new UserProduct();
					product.setId(textProductId.getText());
					product.setName(textName.getText());
					product.setPrice(Double.parseDouble(textPrice.getText()));
					product.setImage(ConvertFile(file.getAbsolutePath()));

					if (dao.addproduct(product) != null) 
					{
						JOptionPane.showMessageDialog(null, "UPLOAD Succesfully");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "UPLOAD UnSuccesfully");
					}
				} catch (Exception e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}

			}

		});
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpload.setBounds(147, 317, 362, 39);
		contentPane.add(btnUpload);

		lblProductImage = new JLabel("Product Image");
		lblProductImage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductImage.setBounds(10, 144, 127, 31);
		contentPane.add(lblProductImage);

		/*
		 * lblNewLabel_1 = new JLabel(""); lblNewLabel_1.setFont(new
		 * Font("Tahoma", Font.BOLD, 16)); lblNewLabel_1.setBounds(147, 141, 46,
		 * 14); contentPane.add(lblNewLabel_1);
		 */

		lblPhoto = new JLabel("");
		lblPhoto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblPhoto.setSize(new Dimension(100, 1000));
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPhoto.setBounds(147, 188, 362, 118);
		contentPane.add(lblPhoto);

		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductId.setBounds(10, 21, 127, 19);
		contentPane.add(lblProductId);

		textProductId = new JTextField();
		textProductId.setColumns(10);
		textProductId.setBounds(147, 19, 362, 20);
		contentPane.add(textProductId);

		btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product product = new Product();
				dispose();

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(147, 367, 362, 39);
		contentPane.add(btnExit);
		
		 lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(10, 108, 127, 19);
		contentPane.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(147, 111, 362, 20);
		contentPane.add(textPrice);
	}
}
