package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	Connection conn;
	
	public SellerDaoJDBC(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			
			st = conn.prepareStatement(
					"SELECT seller.*, "
					+"department.name AS DepName "
					+"FROM seller "
					+"INNER JOIN department ON seller.DepartmentId = department.Id "
					+"WHERE seller.Id = ? "
					);
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()){
				
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				
				Seller objSeller = new Seller();
				objSeller.setId(rs.getInt("Id"));
				objSeller.setName(rs.getString("Name"));
				objSeller.setEmail(rs.getString("Email"));
				objSeller.setBirthDate(rs.getDate("BirthDate"));
				objSeller.setBaseSalary(rs.getDouble("BaseSalary"));
				objSeller.setDepartment(dep);
				
				return objSeller;
			}
			
			return null;
			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
