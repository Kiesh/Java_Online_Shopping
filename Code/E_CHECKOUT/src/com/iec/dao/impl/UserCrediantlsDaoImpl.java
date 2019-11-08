package com.iec.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iec.dao.UserCrediantlsDao;
import com.iec.dbutil.DButil;
import com.iec.entity.UserCrediantls;

public class UserCrediantlsDaoImpl implements UserCrediantlsDao
{
	private Connection connection = DButil.getConnection();

	public boolean loginStatus(UserCrediantls user) {
		boolean result = false;
		String sql = "SELECT * FROM ECO_USER_CREDENTIALS WHERE userId=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String userId = rs.getString(1);
				String password = rs.getString(2);
				if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
					result = true;
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

	public String userType(UserCrediantls user) {
		String userType = null;
		String sql = "SELECT * FROM ECO_USER_CREDENTIALS WHERE userId=? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userType = rs.getString(3);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userType;
	}

	public String addUserCrediantls(UserCrediantls user) {
		String result = "FAIL";
		String sql = "INSERT INTO ECO_USER_CREDENTIALS VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUserType());
			ps.setInt(4, 0);

			int OUTPUT = ps.executeUpdate();
			if (OUTPUT == 1) {
				result = "SUCCESS";

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

}
