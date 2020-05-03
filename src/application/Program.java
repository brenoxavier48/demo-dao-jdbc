package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import db.DB;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("Teste1 === seller findById ===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);
		
		System.out.println("Teste2 === seller findByDepartment ===");
		List<Seller> list = sellerDao.findByDepartment(seller.getDepartment());
		System.out.println(list);
		
	}

}
