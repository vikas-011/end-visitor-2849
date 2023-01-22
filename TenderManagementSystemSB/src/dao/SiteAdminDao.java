package dao;

import java.util.List;

import exception.SiteAdminException;
import model.Project;
import model.SiteAdmin;
import model.Tender;
import model.TenderAdmin;
import model.Vendor;


public interface SiteAdminDao {
	  public SiteAdmin login(String username, String password)  throws SiteAdminException;
		
	  public List<TenderAdmin> getAllTenderAdmin() throws SiteAdminException;
	  
	  public List<Vendor> getAllVendors() throws SiteAdminException;
	  
	  public List<Project> getAllProjects() throws SiteAdminException;
	  
	  public List<Tender>  getAllTenders() throws SiteAdminException;
	  
	  public String removeAVendor(int vid) throws SiteAdminException;
	  
	  public String removeATenderAdmin(int tid) throws SiteAdminException;
}
