package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.SiteAdminException;
import model.Project;
import model.SiteAdmin;
import model.Tender;
import model.TenderAdmin;
import model.Vendor;
import utility.DBUtil;

public class SiteAdminDaoImpl implements SiteAdminDao{
	
	@Override
	public SiteAdmin login(String username, String password) throws SiteAdminException {
		// TODO Auto-generated method stub
		SiteAdmin st = null;
		
		try (Connection con = DBUtil.provideConnection()){
			    PreparedStatement ps =  con.prepareStatement("select * from siteAdmin where email = ? and password = ?");
		        ps.setString(1, username);
			    ps.setString(2, password);
			    ResultSet rs = ps.executeQuery();
			    if(rs.next()) {
			    	  st = new SiteAdmin(rs.getInt("sid"), rs.getString("sname"), rs.getString("email"), rs.getString("password"));
			    
			    
			    }else{
			    	throw new SiteAdminException("Wrong Credentails!");
			    }
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SiteAdminException(e.getMessage());
		}
		
		return st;
	}

	
	
	@Override
	public List<TenderAdmin> getAllTenderAdmin() throws SiteAdminException {
		// TODO Auto-generated method stub
		List<TenderAdmin> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =   con.prepareStatement("select * from TenderAdmin");
		       ResultSet rs =	   ps.executeQuery();
		       while(rs.next()) {
		    	      list.add(new TenderAdmin(rs.getInt("pid"), rs.getString("client"), rs.getString("email"), rs.getString("password"), rs.getString("country"), rs.getString("state"), rs.getString("location"), rs.getString("companyRegistrationNo")));
		       }
			   
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SiteAdminException(e .getMessage());
		}
		
		
		return list;
	}
	
	
	

	@Override
	public List<Vendor> getAllVendors() throws SiteAdminException {
		// TODO Auto-generated method stub
		List<Vendor>  list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =     con.prepareStatement("select * from vendors");
		       ResultSet rs =	   ps.executeQuery();
		       if(rs.next()) {
		    	   list.add(new Vendor(rs.getInt("vid"), rs.getString("vname"), rs.getString("email"), rs.getString("country"), rs.getString("state"), rs.getString("address"), rs.getString("password"), rs.getString("companyRegistrationNum"), rs.getString("gstNum")));
		       }
			   
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SiteAdminException(e .getMessage());
		}
		
		
		return list;
	}
	
	
	

	@Override
	public List<Project> getAllProjects() throws SiteAdminException {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =     con.prepareStatement("select * from projects");
		       ResultSet rs =	   ps.executeQuery();
			   
		       if(rs.next()) {
		    	     list.add(new Project(rs.getInt("pjId"), rs.getString("pTitle"), rs.getString("pSummary"), rs.getString("pDetailsDocLink"), rs.getString("type"), rs.getInt("pAdmin")));
		       }
		       
		       
		       
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SiteAdminException(e .getMessage());
		}
		
		return list;
	}
	
	
	
	

	@Override
	public List<Tender> getAllTenders() throws SiteAdminException {
		// TODO Auto-generated method stub
		List<Tender>  list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =    con.prepareStatement("select* from tenders");
			ResultSet rs = ps.executeQuery();
			 
			while(rs.next()) {
				list.add(new Tender(rs.getInt("tId"), rs.getInt("pjId"), rs.getString("prerequisite"), rs.getDate("startDate"), rs.getDate("endDate")));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SiteAdminException(e.getMessage());
		}
		
		return list;
	}
	
	
	

	@Override
	public String removeAVendor(int vid) throws SiteAdminException {
		// TODO Auto-generated method stub
		String message = "Vendor is not removed";
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =   con.prepareStatement("delete from vendors where vid = ?");
			   ps.setInt(1, vid);
			 int x = ps.executeUpdate();
			if(x > 0) {
				 message = "Vendor is remove who's Id is "+vid;
			}else {
				message = "Oops! there is no vendor registered with id : "+vid;
			}
			      
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SiteAdminException(e.getMessage());
		}
		
		return message;
	}
	
	

	@Override
	public String removeATenderAdmin(int tid) throws SiteAdminException {
		// TODO Auto-generated method stub
		String message = "Tender Admin is not removed";
		
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =   con.prepareStatement("delete from tenderAdmin where pId = ?");
			ps.setInt(1, tid);
			int x =ps.executeUpdate();
			if(x > 0) {
				message = "Tender Admin is removed who's Id is "+tid;
			}else {
				message = "There is no Tender Admin with this id : "+tid;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SiteAdminException(e.getMessage());
		}
		
		return message;
	}


}
