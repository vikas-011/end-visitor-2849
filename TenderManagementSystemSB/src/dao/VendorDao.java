package dao;

import java.util.List;

import exception.VendorException;
import model.CompletedProject;
import model.SelectedApplication;
import model.Tender;
import model.Vendor;
public interface VendorDao {
public String register(Vendor vendor)  throws VendorException;
	
	public Vendor login(String username, String password)  throws VendorException;
	
	public List<Tender>  getAllTender() throws VendorException;
	
	public  String       getTenderDetails(int tenderId) throws VendorException;	
	
	public String  applyforTender(int vendor, int tenderId, String detailsDoc) throws VendorException;
	
    public List<SelectedApplication>  getAllOffer(int vendorId) throws VendorException;
	
	public List<CompletedProject> getProfile(int vid) throws VendorException;
	
}
