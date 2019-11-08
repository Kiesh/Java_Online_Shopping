package com.iec.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.iec.entity.UserCrediantls;
import com.iec.entity.UserProfile;
import com.iec.service.UserService;
import com.iec.serviceDao.impl.UserServiceImpl;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class UserRegistration extends JFrame {
	UserService service = new UserServiceImpl();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUserId;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textDOB;
	private JTextField textStreet;
	private JTextField textLocation;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZip;
	private JTextField textEmail_Id;
	private JTextField textMobileNo;
	private JTextField textUserType;
	private JPasswordField passwordPassword;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

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

	/**
	 * Create the frame.
	 */
	public UserRegistration() {
		ButtonGroup buttonGroup = new ButtonGroup();
		setTitle("Registration Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 522);
		//100, 100, 959, 499
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("REGISTRATION");
		lblNewJgoodiesTitle.setForeground(Color.BLUE);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewJgoodiesTitle.setBounds(263, 11, 162, 28);
		contentPane.add(lblNewJgoodiesTitle);

		JLabel lblNewLabel = new JLabel("User Id");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 48, 68, 14);
		contentPane.add(lblNewLabel);

		textUserId = new JTextField();
		textUserId.setBounds(210, 50, 272, 20);
		contentPane.add(textUserId);
		textUserId.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 83, 81, 14);
		contentPane.add(lblPassword);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLUE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(10, 144, 68, 14);
		contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.BLUE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setBounds(10, 169, 68, 14);
		contentPane.add(lblLastName);

		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(210, 142, 272, 20);
		contentPane.add(textFirstName);

		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(210, 167, 272, 20);
		contentPane.add(textLastName);

		JLabel lblDobddmmyy = new JLabel("DOB (dd/mm/yyyy)");
		lblDobddmmyy.setForeground(Color.BLUE);
		lblDobddmmyy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDobddmmyy.setBounds(10, 200, 130, 14);
		contentPane.add(lblDobddmmyy);

		textDOB = new JTextField();
		textDOB.setColumns(10);
		textDOB.setBounds(210, 198, 272, 20);
		contentPane.add(textDOB);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLUE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(10, 244, 130, 14);
		contentPane.add(lblGender);

		JRadioButton rdbtnM = new JRadioButton("Male");
		rdbtnM.setForeground(Color.BLUE);
		buttonGroup.add(rdbtnM);
		rdbtnM.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnM.setBounds(210, 239, 81, 23);
		contentPane.add(rdbtnM);

		JRadioButton rdbtnF = new JRadioButton("Female");
		rdbtnF.setForeground(Color.BLUE);
		buttonGroup.add(rdbtnF);
		rdbtnF.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnF.setBounds(316, 243, 109, 23);
		contentPane.add(rdbtnF);

		JLabel lblStreet = new JLabel("Street");
		lblStreet.setForeground(Color.BLUE);
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStreet.setBounds(10, 287, 130, 14);
		contentPane.add(lblStreet);

		textStreet = new JTextField();
		textStreet.setColumns(10);
		textStreet.setBounds(210, 285, 272, 20);
		contentPane.add(textStreet);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.BLUE);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocation.setBounds(10, 312, 130, 14);
		contentPane.add(lblLocation);

		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.BLUE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(10, 337, 130, 14);
		contentPane.add(lblCity);

		JLabel lblState = new JLabel("State");
		lblState.setForeground(Color.BLUE);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblState.setBounds(10, 362, 130, 14);
		contentPane.add(lblState);

		JLabel lblZip = new JLabel("Zip");
		lblZip.setForeground(Color.BLUE);
		lblZip.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblZip.setBounds(10, 387, 130, 14);
		contentPane.add(lblZip);

		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setForeground(Color.BLUE);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmailId.setBounds(10, 412, 130, 14);
		contentPane.add(lblEmailId);

		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setForeground(Color.BLUE);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobileNo.setBounds(10, 443, 130, 14);
		contentPane.add(lblMobileNo);

		textLocation = new JTextField();
		textLocation.setColumns(10);
		textLocation.setBounds(210, 310, 272, 20);
		contentPane.add(textLocation);

		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(210, 335, 272, 20);
		contentPane.add(textCity);

		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(210, 360, 272, 20);
		contentPane.add(textState);

		textZip = new JTextField();
		textZip.setColumns(10);
		textZip.setBounds(210, 385, 272, 20);
		contentPane.add(textZip);

		textEmail_Id = new JTextField();
		textEmail_Id.setColumns(10);
		textEmail_Id.setBounds(210, 410, 272, 20);
		contentPane.add(textEmail_Id);

		textMobileNo = new JTextField();
		textMobileNo.setColumns(10);
		textMobileNo.setBounds(210, 441, 272, 20);
		contentPane.add(textMobileNo);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String gender = null;
				String userid = textUserId.getText();
				String password = passwordPassword.getText();
				String userType = textUserType.getText();
				System.out.println("User Type:" + userType);
				String firstName = textFirstName.getText();
				String lastName = textLastName.getText();
				String date = textDOB.getText();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				Date dateOfBirth = null;
				try {
					dateOfBirth = formatter.parse(date);
				} catch (ParseException e) {

					e.printStackTrace();
				}

				if (rdbtnM.isSelected()) {
					gender = "male";
				} else {
					gender = "feamale";
				}

				String street = textStreet.getText();
				String location = textLocation.getText();
				String city = textCity.getText();
				String state = textState.getText();
				String zip = textZip.getText();
				String mobileNo = textMobileNo.getText();
				String emailId = textEmail_Id.getText();

				UserCrediantls user = new UserCrediantls(userid, password, userType);

				// ek naya parameterize constructor banayegai entity class may

				UserProfile profile = new UserProfile(userid, firstName, lastName, dateOfBirth, gender, street,
						location, city, state, zip, mobileNo, emailId);

				String result = service.registration(user, profile);

				System.out.println("Result: " + result);
				UserProfile userProfile=new UserProfile();
				//if(userProfile.getUserId().isEmpty()||userProfile.equals(""))
				//{
					//JOptionPane.showMessageDialog(null, "write the userId");
					
			//	}
				//else{
				JOptionPane.showMessageDialog(null, "Submit Sussesfully");
				//}

				// UserRegistration registration=new UserRegistration();
				// registration.setEnabled(false);

				 UserRegistration registration = new UserRegistration();
				 dispose();

			}

		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(618, 432, 109, 35);
		contentPane.add(btnSubmit);

		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setForeground(Color.BLUE);
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserType.setBounds(10, 108, 81, 14);
		contentPane.add(lblUserType);

		textUserType = new JTextField();
		textUserType.setColumns(10);
		textUserType.setBounds(210, 106, 272, 20);
		contentPane.add(textUserType);

		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(210, 81, 272, 20);
		contentPane.add(passwordPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Manoj\\workspace\\IEC_Project\\IMG\\56591312-silk-shawls-peach-color-as-a-background-Stock-Photo.jpg"));
		lblNewLabel_1.setBounds(0, 0, 965, 483);
		contentPane.add(lblNewLabel_1);
	}
}
