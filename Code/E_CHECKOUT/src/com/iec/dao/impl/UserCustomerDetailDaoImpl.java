package com.iec.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iec.dao.UserCustomerDetailDao;
import com.iec.dbutil.DButil;
import com.iec.entity.UserCustomerDetail;
import com.iec.entity.UserProfile;
import com.iec.service.test.UserServiceCustomerDetail;

public class UserCustomerDetailDaoImpl implements UserCustomerDetailDao {
	// UserCustomerDetailDao customerDetailDao = new
	// UserCustomerDetailDaoImpl();
	UserCustomerDetail customerDetail = new UserCustomerDetail();

	private Connection connection = null;

	public UserCustomerDetailDaoImpl() {
		connection = DButil.getConnection();
	}

	@Override
	public ArrayList<UserProfile> getAll() {
		System.out.println("DAOIMPL");
		ArrayList<UserProfile> list = new ArrayList<UserProfile>();
		String sql = "SELECT * FROM ECO_USER_REGISTER";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData metaDat=rs.getMetaData();
			while (rs.next()) {
				String userId = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Date DateOfBirth = rs.getDate(4);
				String gender = rs.getString(5);
				String street = rs.getString(6);
				String location = rs.getString(7);
				String city = rs.getString(8);
				String state = rs.getString(9);
				String zip = rs.getString(10);
				String emailId = rs.getString(11);
				String mobileNo = rs.getString(12);

				UserProfile profile = new UserProfile(userId, firstName, lastName, DateOfBirth, gender, street,
						location, city, state, zip, mobileNo, emailId);

				list.add(profile);

				/*
				 * for (UserProfile userProfile : list) {
				 * System.out.println(userProfile);
				 * 
				 * }
				 */

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String delete(UserCustomerDetail customerDetail) {
		System.out.println("delete");

		String result = "Fail";
		String sql = "DELETE FROM ECO_USER_REGISTER WHERE USERID=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, customerDetail.getUserId());

			// String id=customerDetail.getUserId();

			int rs = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @Override public String update(UserCustomerDetail detail) { String sql =
	 * "UPDATE ECO_USER_REGISTER SET PRICE=? ";
	 * 
	 * try { PreparedStatement ps = connection.prepareStatement(sql);
	 * ps.setString(1, customerDetail.get); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return null; }
	 */

}
