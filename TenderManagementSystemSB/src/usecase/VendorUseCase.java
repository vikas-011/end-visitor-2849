package usecase;

import java.util.List;

import app.Main;
import dao.VendorDao;
import dao.VendorDaoImpl;
import exception.VendorException;
import model.CompletedProject;
import model.SelectedApplication;
import model.Tender;
import model.Vendor;

public class VendorUseCase {
    /// all usecase of vendor

    VendorDao dao = new VendorDaoImpl();
    
    private Vendor vendor = null;
    
    public void register() {
    	     System.out.println("Enter  Details to Register as a Vendor");
    	     
    	     Main.sc.nextLine();
    	     System.out.println("Enter the Name :");
    	     String vname = Main.sc.nextLine();
    	     
    	     System.out.println("Enter email :");
    	     String email = Main.sc.nextLine();
    	     
    	     
    	     System.out.println("Enter Country :");
    	     String country = Main.sc.nextLine();
    	     
    	     
    	     System.out.println("Enter State :");
    	     String state = Main.sc.nextLine();
    	     
    	     System.out.println("Enter address :");
    	     String address = Main.sc.nextLine();
    	     
    	     System.out.println("Enter Company registeration number :");
    	     String comRegistrationNum = Main.sc.nextLine();
    	     
    	     System.out.println("Enter GST Numnber");
    	     String gstNum = Main.sc.next();
    	     
    	     System.out.println("Enter Password :");
    	     String password = Main.sc.next();
    	     
    	     Vendor vn = new Vendor();
    	     
    	     vn.setVname(vname);
    	     vn.setEmail(email);
    	     vn.setCountry(country);
    	     vn.setState(state);
             vn.setAddress(address);
             vn.setCompanyRegistrationNum(comRegistrationNum);
             vn.setGstNum(gstNum);
             vn.setPassword(password);
             
             
             
             
             try {
				  String message = dao.register(vn);
				  System.out.println(message);
			} catch (VendorException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				Main.vendor();
			}
             
             
    
    
    
    }
    
    
    public void login() {
    	  System.out.println("Enter the Credentails :");
    	  
    	  System.out.println("Enter email :");
    	  String email = Main.sc.next();
    	  
    	  System.out.println("Enter the password");
    	  String password = Main.sc.next();
    	  
    	  try {
			vendor = dao.login(email, password);
			if(vendor != null) {
				 System.out.println("Logined Seccussfully");
				 this.move();
			}else {
				System.out.println("Wrong Credentials!");
				Main.vendor();
			}
		} catch (VendorException e) {
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
    
    public void options() {
		  
		  System.out.println("You can do following Activity");
	    	System.out.println("1. See LIst of Tenders");
	    	System.out.println("2. See tender details");
	    	System.out.println("3. Apply for a tender");
	    	System.out.println("4. See List of Offer");
	    	System.out.println("5. See your Feedback ");
	    	System.out.println("6. Move to previous operations\n");
	    	
	    	System.out.println("Enter a key from 1 to 6");
	    	
	        int key =	Main.sc.nextInt();
	        
	        switch (key) {
			case 1: {
				
				this.tenderList();
				break;
			}
	        case 2: {
				
				this.getTenderDetails();
				break;
			}
	        case 3: {
				
				this.applyForTender();
				break;
			}
	       case 4: {
				
				this.getListOfOffer();
				break;
			} 
	       case 5:{
	    	   
	    	   this.getProfile();
	    	   break;
	       }
          case 6:{
	    	   String[] st = { "new"};
	    	   Main.main(st);
	    	   break;
	       }
	       
			default:
				System.out.println("\nInput is incorrect \n");
				this.options();
			}
		  
	  }
    
    
    public void tenderList() {
    	   try {
		     List<Tender> list =	dao.getAllTender() ;
		     if(!list.isEmpty()) {
		    	 System.out.println("List of all Tender is folllowing : ");
		    	 list.forEach(s -> System.out.println(s));
		     }else {
		    	 System.out.println("Oops! there is no tender listed");
		     }
		} catch (VendorException e) {
			// TODO Auto-generated catch block
		     System.out.println(e.getMessage());
		} finally {
			this.move();
		}
    }
    
    
    public void getTenderDetails() {
    	   System.out.println("Enter Tender Id to get all Details :");
    	   int tId = Main.sc.nextInt();
    	   
    	   try {
			  String message =   dao.getTenderDetails(tId);
			   System.out.println(message);
			} catch (VendorException e) {
				// TODO Auto-generated catch block
			     System.out.println(e.getMessage());
			} finally {
				this.move();
			}
    }
    
    
    public void applyForTender() {
    	     System.out.println("Enter Details to Apply for a tender");

    	     
    	     System.out.println("Enter Tender Id :");
             int tid = Main.sc.nextInt();
             
             Main.sc.nextLine();
             System.out.println("Enter detailed Application Link");
             String detailsDoc = Main.sc.nextLine();
             
             try {
			    String message =	dao.applyforTender(vendor.getVid(), tid, detailsDoc);
			    System.out.println(message);
			} catch (VendorException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				this.move();
			}
    }
    
    public void getListOfOffer() {
    	     try {
			    List<SelectedApplication>	list = dao.getAllOffer(vendor.getVid());
			    if(!list.isEmpty()) {
			    	System.out.println("List of your selected applications of tenders");
			    	list.forEach(s -> System.out.println(s));
			    }else {
			    	 System.out.println("Oops! there is no application ");
			     }
			} catch (VendorException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}finally {
				this.move();
			}
    }
    public void getProfile() {
    	   
    	try {
		    List<CompletedProject>	list = 	dao.getProfile(vendor.getVid());
		    if(!list.isEmpty()) {
		    	System.out.println("The list of completed projects feedback");
		    	list.forEach(l -> System.out.println(l));
		    }else {
		    	 System.out.println("Oops! there is no feedback.");
		     }
		} catch (VendorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			this.move();
		}
    }
    
}
