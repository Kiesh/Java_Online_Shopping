package com.iec.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.iec.dao.UserCustomerDetailDao;
import com.iec.dao.impl.UserCustomerDetailDaoImpl;
import com.iec.entity.UserCustomerDetail;
import com.iec.entity.UserProfile;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DisplayCustomerList extends JFrame 
{
	UserCustomerDetailDao dao = new UserCustomerDetailDaoImpl();

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnDeleteRecord;
	private JLabel lblUserId;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
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

	/**
	 * Create the frame.
	 */
	public DisplayCustomerList() {
		setFont(new Font("Dialog", Font.BOLD, 17));
		setTitle("DisplayCustomerList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 959, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDisplay = new JButton("DISPLAY");
		table = new JTable();

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(new String[] { "UseId", "FirstName", "LastName" });

		// model.setColumnIdentifiers(new String[] { "New column", "New column"
		// });
		// set in the table model
		table.setModel(model);

		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ArrayList<UserProfile> list = new ArrayList<UserProfile>();
				ArrayList<UserProfile> list = dao.getAll();

				DefaultTableModel model1 = new DefaultTableModel();
				model1.setColumnIdentifiers(new String[] { "UseId", "FirstName", "LastName", "DateOfBirth", "Gender",
						"Street", "Location", "City", "State", "EmailId", "MobileNo." });
				for (UserProfile u : list) {

					model1.addRow(new Object[] { u.getUserId(), u.getFirstName(), u.getLastName(), u.getDateOfBirth(),
							u.getGender(), u.getStreet(), u.getLocation(), u.getCity(), u.getState(),
							u.getMobileNumber(), u.getEmailId() });

				}
				table.setModel(model1);
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDisplay.setBounds(173, 11, 495, 31);
		contentPane.add(btnDisplay);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayCustomerList displayCustomerList = new DisplayCustomerList();
				dispose();

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(186, 232, 471, 31);
		contentPane.add(btnExit);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 933, 168);
		contentPane.add(scrollPane);

		// table = new JTable();
		JPanel panel = new JPanel();
		scrollPane.setViewportView(table);

		btnDeleteRecord = new JButton("DELETE RECORD");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
             	String id = textFieldId.getText();
				UserCustomerDetail user = new UserCustomerDetail(id);
				String r = dao.delete(user);
				// code for deleting row from writing textfield;
				for (int i = 0; i < model.getRowCount(); i++) 
				{
					if (((String) model.getValueAt(i, 0)).equals(id)) 
					{
						model.removeRow(i);
						break;
					}
				}
				//table.setModel(model);

			}
		});
		btnDeleteRecord.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteRecord.setBounds(197, 364, 471, 36);
		contentPane.add(btnDeleteRecord);

		lblUserId = new JLabel("UseId");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserId.setBounds(122, 306, 58, 14);
		contentPane.add(lblUserId);

		textFieldId = new JTextField();
		textFieldId.setBounds(190, 305, 467, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
	}
}
