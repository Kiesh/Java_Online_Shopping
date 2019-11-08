package com.iec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iec.dao.UserProductDao;
import com.iec.dbutil.DButil;
import com.iec.entity.UserProduct;

public class UserProductDaoImpl implements UserProductDao {
	// connection of database to dao layer ko
	private Connection connection = null;

	public UserProductDaoImpl() {
		connection = DButil.getConnection();
	}

	@Override
	public String addproduct(UserProduct userProduct) {

		String sql = "INSERT INTO ECO_USER_CREDIANTLS_PRODUCT VALUES(?,?,?,?)";

		String result = "FAIL";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setDouble(3, userProduct.getPrice());
			ps.setString(1, userProduct.getId());

			ps.setString(2, userProduct.getName());

			ps.setBytes(4, userProduct.getImage());

			int output = ps.executeUpdate();

			if (output > 1) {
				result = "success";

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return result;
	}

	@Override
	public ArrayList<UserProduct> getAll() {

		ArrayList<UserProduct> list = new ArrayList<UserProduct>();
		String sql = "SELECT * FROM  ECO_USER_CREDIANTLS_PRODUCT";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				byte[] image = rs.getBytes(4);

				UserProduct userProduct = new UserProduct(id, name, price, image);
				list.add(userProduct);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	/*
	 * public String deleteProduct(UserProduct userProduct) { String sql =
	 * "DELETE FROM FROM WHERE PRICE=?"; String result = "Fail"; try {
	 * 
	 * PreparedStatement ps = connection.prepareStatement(sql); ps.setString(1,
	 * userProduct.getPrice() + ""); int rs = ps.executeUpdate(); } catch
	 * (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return result; }
	 */

	@Override
	public String uploadProduct(UserProduct product) {
		String result = "Fail";

		String sql = "UPDATE ECO_USER_CREDIANTLS_PRODUCT SET  NAME='" + product.getName() + "',PRICE='"
				+ product.getPrice() + "'  WHERE ID ='" + product.getId() + "'";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// ps.setString(1, product.getId());
			// ps.setString(2, product.getName());
			// ps.setString(3, product.getPrice() +"");
			// ps.setBytes(4, null);

			int rs = ps.executeUpdate();
			if (rs > 0) {
				System.out.println("Existing user updated successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
