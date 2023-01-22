package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.TenderAdminException;
import model.Application;
import model.Feedback;
import model.Project;
import model.Tender;
import model.TenderAdmin;
import utility.DBUtil;

public class TenderAdminDaoImpl implements TenderAdminDao{
	
	@Override
	public String register(TenderAdmin admin) throws TenderAdminException {
		// TODO Auto-generated method stub
		String message  = "Not registerd ...";
		
		try (Connection con =DBUtil.provideConnection()){
				 PreparedStatement ps = con.prepareStatement("insert into tenderAdmin(client, email, location, password, country, state, companyRegistrationNo) values(?,?,?,?,?,?,?) ");
				 ps.setString(1, admin.getClient()); 
				 ps.setString(2, admin.getEmail());
				 ps.setString(3, admin.getLocation());
				 ps.setString(4, admin.getPassword());
				 ps.setString(5, admin.getCountry());
				 ps.setString(6, admin.getState());
				 ps.setString(7, admin.getCompanyRegistrationNo());
			    int x =	 ps.executeUpdate();
			    
			    if(x>0)
			    	message = "Congratulation! Your company is registered Seccussfully";
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public TenderAdmin login(String username, String password) throws TenderAdminException {
		// TODO Auto-generated method stub
		TenderAdmin pAdmin = null;
		
		try (Connection con = DBUtil.provideConnection()){
			     PreparedStatement ps =   con.prepareStatement("select * from tenderAdmin where email=? and password=?");
		         ps.setString(1, username);
		         ps.setString(2, password);
		       ResultSet rs =    ps.executeQuery();
		       if(rs.next()) {
		    	   pAdmin = new TenderAdmin(rs.getInt("pid"), rs.getString("client"), rs.getString("email"), rs.getString("password"), rs.getString("country"), rs.getString("state"), rs.getString("location"), rs.getString("companyRegistrationNo"));
		       }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException();
		}
		
		return pAdmin;
	}

	@Override
	public String addProject(Project pr) throws TenderAdminException {
		// TODO Auto-generated method stub
		String message = "project not added ..";
		
		try (Connection con = DBUtil.provideConnection()){
			  PreparedStatement ps =   con.prepareStatement("insert into projects(pTitle, pSummary, pDetailsDocLink, type, pAdmin)"
			     		+ "values(?,?,?,?,?)");
			    ps.setString(1, pr.getpTitle());
			    ps.setString(2, pr.getpSummary());
			    ps.setString(3, pr.getpDetailesDocLink());
			    ps.setString(4, pr.getType());
			    ps.setInt(5, pr.getpAdmin());
			    
			  int x =   ps.executeUpdate();
			  if(x >0) {
				  message = "Congratulation! Your Project is listed";
			  }
			     
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Project> getAllProject(int tAdminId) throws TenderAdminException {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			  PreparedStatement ps =    con.prepareStatement("select * from projects where pAdmin = ?");
			  ps.setInt(1, tAdminId);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				list.add(new Project(rs.getInt("pjId"), rs.getString("pTitle"), rs.getString("pSummary"), rs.getString("pDetailsDocLink"), rs.getString("type"), rs.getInt("pAdmin")));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public String createTenderofAproject(Tender tender) throws TenderAdminException {
		// TODO Auto-generated method stub
		tender.setStartDate(Date.valueOf(LocalDate.now()));
		String message = "Tender for project ID: "+tender.getPjId()+" is not created";
		
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =   con.prepareStatement("insert into tenders(pjId, prerequisite, startDate, endDate) values(?,?,?,?)");
			ps.setInt(1, tender.getPjId());
			ps.setString(2, tender.getPrerequisite());
			ps.setDate(3, Date.valueOf(LocalDate.now()));
			ps.setDate(4, tender.getEndDate());
			
		  int x = ps.executeUpdate();
		  if(x>0) {
			  message = "Congratulations! Tender for your project id"+tender.getPjId()+"is created";
		  }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String deleteTender(int projectId) throws TenderAdminException {
		// TODO Auto-generated method stub
		String message = "Tender of Project ID: " +projectId+ "  is not removed";
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =    con.prepareStatement("delete from Tenders where pjId = ?");
			   ps.setInt(1, projectId);
			  int x =   ps.executeUpdate();
			   if(x >0) {
				   message = "Tender of Project ID: " +projectId+ " is removed";
			   }
			   
			   
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException();
		}
		
		return message;
	}

	@Override
	public List<Application> getAllAppOfTender(int projectId) throws TenderAdminException {
		// TODO Auto-generated method stub
		List<Application> list = new ArrayList<>();
		
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =   con.prepareStatement("select*from applytoTender where tid= (select tid from tenders where pjId= ?)");
			   ps.setInt(1, projectId);
			  ResultSet rs =  ps.executeQuery();
			  while(rs.next()) {
				  list.add(new Application(rs.getInt("apId"), rs.getInt("vid"), rs.getInt("tid"), rs.getString("detailsDoc"), rs.getString("aStatus")));
			  }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException();
		}
		
		return list;
	}
  
	@Override
	public String selectAppforTender(int appId, Date bidingDate, String city, String location) throws TenderAdminException {
		// TODO Auto-generated method stub
		String message = "Application id:"+appId+" is not selected for tender";
		
		try (Connection con = DBUtil.provideConnection()){
			  PreparedStatement ps = con.prepareStatement("insert into selecteApplication(apId, bidingDate, city, location) values(?,?,?,?)");
			  ps.setInt(1, appId);
			  ps.setDate(2, bidingDate);
			  ps.setString(3, city);
			  ps.setString(4,  location);
			 int x =  ps.executeUpdate();
			 if(x>0) {
				 message = "Application id:"+appId+" is selected for tender";
			 }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String givefeeback(Feedback fb) throws TenderAdminException {
		// TODO Auto-generated method stub
		String message = "feedback is not Added";
		
		try (Connection con = DBUtil.provideConnection()){
			 PreparedStatement ps =  con.prepareStatement("insert into projectCompletion(vid, pjid, rating, feedback) values(?,?,?,?)");
			 ps.setInt(1, fb.getVendorId());
			 ps.setInt(2, fb.getProjectId());
			 ps.setInt(3, fb.getRating());
			 ps.setString(4, fb.getComment());
			 
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "feedback is added for vendor  Id"+fb.getVendorId()+ " and project Id :"+ fb.getProjectId();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new TenderAdminException(e.getMessage());
		}
		
		return message;
	}

}
