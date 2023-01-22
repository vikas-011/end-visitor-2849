package dao;

import java.sql.Date;
import java.util.List;

import exception.TenderAdminException;
import model.Application;
import model.Feedback;
import model.Project;
import model.Tender;
import model.TenderAdmin;


public interface TenderAdminDao {
	public String  register(TenderAdmin admin)  throws TenderAdminException;
    
    public TenderAdmin login(String username, String password) throws TenderAdminException;
    
    
    public String addProject(Project pr) throws TenderAdminException;
    
    
    public List<Project> getAllProject(int tAdminId) throws TenderAdminException;
    
    public String createTenderofAproject(Tender tender) throws TenderAdminException;
    
    public String deleteTender(int projectId) throws TenderAdminException;
    
    public List<Application>  getAllAppOfTender(int projectId)  throws TenderAdminException;
    
    public  String   selectAppforTender(int appId, Date bidingDate, String city, String location) throws TenderAdminException;
    
    public  String  givefeeback(Feedback fb) throws TenderAdminException;
    
}
