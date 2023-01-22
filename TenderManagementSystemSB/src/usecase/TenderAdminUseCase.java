package usecase;

import java.sql.Date;
import java.util.List;

import app.Main;
import dao.TenderAdminDao;
import dao.TenderAdminDaoImpl;
import exception.TenderAdminException;
import model.Application;
import model.Feedback;
import model.Project;
import model.Tender;
import model.TenderAdmin;

public class TenderAdminUseCase {
    // all the Usecases for the Tender admin are listed as individiual method
	  public TenderAdminDao dao = new TenderAdminDaoImpl();
	  
	  private TenderAdmin ta = null;
	  
	  
	  public void register() {
		  
		     System.out.println("Enter the details for registration");
		     Main.sc.nextLine();
		      
		      System.out.println("Enter company name :");
		      String client = Main.sc.nextLine();
		      
		      System.out.println("Enter Email");
		      String email = Main.sc.nextLine();
		      
		      System.out.println("Enter Country ");
		      String country = Main.sc.nextLine();
		      
		      System.out.println("Enter State");
		      String state = Main.sc.nextLine();
		      
		      System.out.println("Enter location");
		      String location = Main.sc.nextLine();
		      
		      System.out.println("Enter Company Registration No");
		      String comregistrationNo = Main.sc.nextLine();
		      
		      System.out.println("Enter Password");
		      String password = Main.sc.next();
		      
		      
		     TenderAdmin pAdmin = new TenderAdmin();
		      
		      pAdmin.setClient(client);
		      pAdmin.setEmail(email);
		      pAdmin.setCountry(country);
		      pAdmin.setState(state);
		      pAdmin.setLocation(location);
		      pAdmin.setCompanyRegistrationNo(comregistrationNo);;
		      pAdmin.setPassword(password);
		      
		      try {
			    String result =	dao.register(pAdmin);
			    System.out.println(result);
			    
			} catch (TenderAdminException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				Main.tendorAdmin();
			}
		      
		      
	  }
	  
	  
	  public void options() {
		  
		  System.out.println("You can do following Activity");
	    	System.out.println("1. Add a Project");
	    	System.out.println("2. See all listed Projects");
	    	System.out.println("3. Create a Tender for a Project");
	    	System.out.println("4. Delete a Tender");
	    	System.out.println("5. See All application for a tender");
	    	System.out.println("6. Select a application for a tender");
	    	System.out.println("7. Give feedback to a vendor for project");
	    	System.out.println("8. Move to previous operations\n");
	    	
	    	System.out.println("Enter a key from 1 to 7");
	    	
	        int key =	Main.sc.nextInt();
	        
	        switch (key) {
			case 1: {
				
				this.addProject();
				break;
			}
	        case 2: {
				
				this.projectList();
				break;
			}
	        case 3: {
				
				this.createTender();
				break;
			}
	       case 4: {
				
				this.deleteTender();
				break;
			} 
	       case 5:{
	    	   
	    	   this.allApplicationOfTender();
	    	   break;
	       }
	       case 6:{
	    	   
	    	   this.selectApplicationForTender();
	    	   break;
	       }
	       case 7:{
	    	   
	    	   this.giveFeedback();
	    	   break;
	       }
	       case 8:{
	    	   String[] st = { "new"};
	    	   Main.main(st);
	    	   break;
	       }
			default:
				System.out.println("\nInput is incorrect \n");
				this.options();
			}
		  
	  }
	  
	  public void login() {
		     System.out.println("Enter Email Id :");
		     String email = Main.sc.next();
		     
		     System.out.println("Enter Password ");
		     String password = Main.sc.next();
		     
		     
		     
		     
		     
		     try {
			     ta =	dao.login(email, password);
			    if(ta != null) {
			    	System.out.println("Logined Seccussfully.\n");
			    	this.move();
			    }else {
			    	System.out.println("Opps! Wrong Credentials.\n");
			    	Main.tendorAdmin();
			    }
			} catch (TenderAdminException e) {
				// TODO Auto-generated catch block
				  System.out.println(e.getMessage());
			}
		     
		     
	  }


	  public void move() {
		  System.out.println("\nDo you want to perform more operations? (y/n)");
			
			String key = Main.sc.next();
			switch (key) {
			case "y": {
				
				this.options();
				break;
			}
	       case "n": {
				

	            System.out.println("Hope! you will come back soon. Thank you");
	            Main.sc.close();
				break;
			}
			default:
				System.out.println("Incorrect Input. Please Try Again");
				this.move();
			}
	  }
	  
	  
	  
    public void addProject() {
 	      System.out.println("Enter details to add a new project : ");
 	      Main.sc.nextLine();
 	      System.out.println("Enter project title : ");
 	      String pTitle = Main.sc.nextLine();
 	      
 	      System.out.println("Enter the project summary : ");
 	      String pSummary = Main.sc.nextLine();
 	      
 	      System.out.println("Enter Detailed Document Link : ");
 	      String pDetailedLink = Main.sc.nextLine();
 	      
 	      
 	      System.out.println("Enter The type of Project : ");
 	      String type = Main.sc.nextLine();
 	      
 	      Project p= new Project();
 	      p.setpTitle(pTitle);
 	      p.setpSummary(pSummary);
 	      p.setpDetailesDocLink(pDetailedLink);
 	      p.setType(type);
 	      p.setpAdmin(ta.getPid());
 	      
 	      
 	      try {
				String result = dao.addProject(p);
				System.out.println(result);
			} catch (TenderAdminException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.move();
			}
    }
    
    
    public void projectList() {
 	   
 	   
 	   try {
		   List<Project> list =	dao.getAllProject(ta.getPid());
		   if(!list.isEmpty()) {
			    System.out.println("List of all projects :");
			    list.forEach(p -> System.out.println(p));
		   }else {
			   System.out.println("Oops ! you did not listed any project yet");
		   }
		} catch (TenderAdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}finally {
			this.move();
		}
 	   
    }
    
    
    public void createTender() {
 	   System.out.println("Enter the details to make a tender for listed project");
 	      System.out.println("Enter the project ID :");
 	      int pjId = Main.sc.nextInt();
 	      
 	      
 	      Main.sc.nextLine();
 	      System.out.println("Enter the Pre-requisite for project");
 	      String pre = Main.sc.nextLine();
 	      
 	      System.out.println("Last Date of Tender  :(in YYYY-MM-DD format)");
 	      String d = Main.sc.nextLine();
 	     
 	      Tender t = new Tender();
 	      t.setPjId(pjId);
 	      t.setPrerequisite(pre);
 	      t.setEndDate(Date.valueOf(d));
 	      
 	     try {
			  String result = 	dao.createTenderofAproject(t) ;
			  System.out.println(result);
			} catch (TenderAdminException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				this.move();
			}
 	      
 	      
    }

    public void deleteTender() {
 	        System.out.println("Enter a project Id for Deletion of tender of project :");
 	        int pjId = Main.sc.nextInt();
 	        
 	        try {
				   String result =	dao.deleteTender(pjId);
				      System.out.println(result);
				} catch (TenderAdminException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}finally {
					this.move();
				}
    }
    
    public void allApplicationOfTender() {
 	       System.out.println("Enter the project ID to get all aplication for tender");
 	       int pjId = Main.sc.nextInt();
 	        try {
				List<Application> list =	dao.getAllAppOfTender(pjId);
				   if(!list.isEmpty()) {
					   System.out.println("\nList of all Application of Tender for prject Id : "+pjId);
					   list.forEach(a -> System.out.println(a));
				   }else {
					  System.out.println("\nOops! Either there is no tender for this project or there is no one applied");
					  
				   }
				} catch (TenderAdminException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}finally {
					this.move();
				}
    }
    
    public void selectApplicationForTender() {
 	     System.out.println("Enter Details to Select a application and Personal meeting for tender :");
 	     
 	     
 	     System.out.println("Enter a Application Id :");
 	     int apId = Main.sc.nextInt();
 	     
 	     System.out.println("Enter final biding date : (In YYYY-MM-DD format)");
 	     String d = Main.sc.next();
 	     
 	     System.out.println("Enter City :");
 	     String city = Main.sc.next();
 	     
 	     
 	     Main.sc.nextLine();
 	     System.out.println("Enter Location :");
 	     String location = Main.sc.nextLine();
 	     
 	   try {
		     String message =	dao.selectAppforTender(apId, Date.valueOf(d), city, location);
		     System.out.println(message);
		} catch (TenderAdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			this.move();
		}
 	  
    }
    
    public void giveFeedback() {
 	       System.out.println("Enter Details to give feedback to vendor for a Project :");
 	       
 	       System.out.println("Enter Vender Id :");
 	       int vid = Main.sc.nextInt();
 	       
 	       System.out.println("Enter Project Id :");
 	       int pjId = Main.sc.nextInt();
 	       
 	       System.out.println("Give the rating on Scale 0 to 5");
 	       int rating = Main.sc.nextInt();
 	       
 	       
 	       Main.sc.nextLine();
 	       System.out.println("Enter the Comment");
 	       String comment = Main.sc.nextLine();
 	       
 	       Feedback fb = new Feedback();
 	       fb.setVendorId(vid);
 	       fb.setProjectId(vid);
 	       fb.setRating(rating);
 	       fb.setComment(comment);
 	       
 	       
              try {
				     String message =	dao.givefeeback(null);
				     System.out.println(message);
				} catch (TenderAdminException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}finally{
					this.move();
				}
    }


}