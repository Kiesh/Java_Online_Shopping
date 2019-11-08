package com.iec.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.iec.dao.UserProfileDao;
import com.iec.dbutil.DButil;
import com.iec.entity.UserProfile;

public class UserProfileDaoImpl implements UserProfileDao 
{
	//private Connection connection = DButil.getConnection();
	private Connection connection = null;
	public UserProfileDaoImpl() 
	{
		connection = DButil.getConnection();
	}
	// to get connected with the database

	public String addUserProfile(UserProfile userProfile) {
		String result = "FAIL";
		String sqlReg = "INSERT INTO ECO_USER_REGISTER VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sqlReg);
			ps.setString(1, userProfile.getUserId());
			//ps.setString(2, userProfile.getPassword());
			//ps.setString(3, userProfile.getUserType());
			ps.setString(2, userProfile.getFirstName());
			ps.setString(3, userProfile.getLastName());

			ps.setDate(4, new java.sql.Date(userProfile.getDateOfBirth().getTime()));

			// here date first convert into the java utill then convert into the
			// sql
			ps.setString(5, userProfile.getGender());
			ps.setString(6, userProfile.getStreet());
			ps.setString(7, userProfile.getLocation());
			ps.setString(8, userProfile.getCity());
			ps.setString(9, userProfile.getState());
			ps.setString(10, userProfile.getZip());
			ps.setString(11, userProfile.getMobileNumber());
			ps.setString(12, userProfile.getEmailId());

			int output = ps.executeUpdate();

			if (output > 1) {
				result = "SUCCESS";
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Result from User Profile DaoImpl" + result);
		return result;

	}

}
