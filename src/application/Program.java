package application;

import java.sql.Connection;
import java.sql.SQLException;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import db.DB;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(5);
		
		System.out.println(seller);
	}

}
