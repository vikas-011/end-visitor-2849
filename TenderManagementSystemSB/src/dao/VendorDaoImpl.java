package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.VendorException;
import model.CompletedProject;
import model.Profile;
import model.SelectedApplication;
import model.Tender;
import model.Vendor;
import utility.DBUtil;

public class VendorDaoImpl implements VendorDao{
	
	@Override
	public String register(Vendor vendor) throws VendorException {
		// TODO Auto-generated method stub
		String message = "Not Registered Yet";
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =  con.prepareStatement("insert into vendors(vname, email, country, state, address, password) values(?,?,?,?,?,?)");
			   ps.setString(1, vendor.getVname());
			   ps.setString(2, vendor.getEmail());
			   ps.setString(3, vendor.getCountry());
			   ps.setString(4, vendor.getState());
			   ps.setString(5, vendor.getAddress());
			   ps.setString(6, vendor.getPassword());
			   
			    int x = ps.executeUpdate();
			    if(x>0) {
			    	message = "Congrutulations! You registered as Vendor";
			    }
			   
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new VendorException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public Vendor login(String username, String password) {
		// TODO Auto-generated method stub
		Vendor vendor = null;
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps =    con.prepareStatement("select * from vendors where email = ? and password = ?");
			    ps.setString(1, username);
			    ps.setString(2, password);
			  ResultSet rs =  ps.executeQuery();
			  if(rs.next()) {
				  vendor = new Vendor(rs.getInt("vid"), rs.getString("vname"), rs.getString("email"), rs.getString("country"), rs.getString("state"), rs.getString("address"), rs.getString("companyRegistrationNum"), rs.getString("gstNum"), rs.getString("password"));
			  }
			      
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return vendor;
	}

	@Override
	public List<Tender> getAllTender() throws VendorException {
		// TODO Auto-generated method stub
		List<Tender> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("select * from tenders where endDate >= ?");
			   ps.setDate(1, Date.valueOf(LocalDate.now())); 
			  ResultSet rs =   ps.executeQuery();
			  while(rs.next()) {
				  list.add(new Tender(rs.getInt("tid"), rs.getInt("pjId"), rs.getString("prerequisite"), rs.getDate("startDate"), rs.getDate("endDate")));;
			  }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new VendorException();
		}
		
		return list;
	}

	@Override
	public String getTenderDetails(int tenderId) throws VendorException {
		// TODO Auto-generated method stub
	String message = "There is not details";
		
		try (Connection con = DBUtil.provideConnection()){
			  PreparedStatement ps =   con.prepareStatement("select t.tid, t.startDate, t.endDate, t.prerequisite, p.pTitle, p.pSummary, p.pDetailsDocLink, "
			     		+ "p.type, p.pAdmin   from projects p INNER JOIN tenders t ON p.pjid = t.tId And t.tID = ?");
			  ps.setInt(1, tenderId);
			  ResultSet rs = ps.executeQuery();
			  if(rs.next()) {
				  message = "tender id :"+ rs.getInt("tid")+"\n"
				  		+ "tender starting date is" + rs.getDate("startDate")+"\n"
				  		+ "ending date is "+rs.getDate("endDate")+"\n"
				  		+"Prerequisite for Tender :" + rs.getString("prerequisite")+"\n"
				  		+ "\n project Details are following :\n"
				  		+ "Title :"+rs.getString("pTitle")+"\n"
				  		+"Summary :"+rs.getString("pSummary")+"\n"
				  		+"Detailed Document Link :"+rs.getString("pDetailsDocLink")+"\n"
				  		+"Type :" +rs.getString("type")+"\n"
				        +"Tender Admin ID : "+rs.getInt("pAdmin");
			  }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new VendorException();
		}
		
		return message;
	}

	@Override
	public String applyforTender(int vendorId, int tenderId, String detailsDoc) throws VendorException {
		// TODO Auto-generated method stub
		String message = "Not applied for Tender  id :"+ tenderId;
		
		try (Connection con = DBUtil.provideConnection()){
			   PreparedStatement ps = con.prepareStatement("insert into applytoTender(vid, tid, detailsDoc)  values(?, ?, ?)");
			   ps.setInt(1, vendorId);
			   ps.setInt(2, tenderId);
			   ps.setString(3, detailsDoc);
			  int x =  ps.executeUpdate();
			  
			  if(x>0) {
				  message = "Congrutulations! you seccussfuly applied for tender id"+tenderId;
			  }
			   
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new VendorException(e.getMessage());
			
		}
		
		return message;
	}

	@Override
	public List<SelectedApplication> getAllOffer(int vendorId) throws VendorException {
		// TODO Auto-generated method stub
				List<SelectedApplication> list = new ArrayList<>();
				
				try (Connection con = DBUtil.provideConnection()){
					PreparedStatement ps =con.prepareStatement("select * from selectedApplication where apid = All(select apId from applytoTender where vid = ?)");
					   ps.setInt(1, vendorId); 
					  ResultSet rs =   ps.executeQuery();
					  while(rs.next()) {
						  list.add(new SelectedApplication(rs.getInt("slId"), rs.getInt("apId"), rs.getDate("bidingDate"), rs.getString("city"), rs.getString("location")));
					  }
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
					throw new VendorException();
				}
				
				return list;
	}

	@Override
	public List<CompletedProject> getProfile(int vid) throws VendorException {
		// TODO Auto-generated method stub
		 List<CompletedProject> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			  PreparedStatement ps =     con.prepareStatement("select * from projectcompletion where vid = ?");
			  ps.setInt(1, vid);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				list.add(new CompletedProject(rs.getInt("rtid"), rs.getInt("vid"), rs.getInt("pjid"), rs.getInt("rating"), rs.getString("comment")));
			
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new VendorException();
		}
		
		return list;
	}

}
