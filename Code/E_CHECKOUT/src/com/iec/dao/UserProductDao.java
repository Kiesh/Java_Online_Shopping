package com.iec.dao;

import java.util.ArrayList;

import com.iec.entity.UserProduct;

public interface UserProductDao
{
	
	public String addproduct(UserProduct userProduct);
	
	public ArrayList<UserProduct>getAll();
//	public String deleteProduct(UserProduct userProduct);
	public String uploadProduct(UserProduct product);
	
	
	

}
