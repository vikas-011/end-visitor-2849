package usecase;

import java.util.List;

import app.Main;
import dao.SiteAdminDao;
import dao.SiteAdminDaoImpl;
import exception.SiteAdminException;
import model.Project;
import model.SiteAdmin;
import model.Tender;
import model.TenderAdmin;
import model.Vendor;

public class SiteAdminUseCase {
    // All Usecasse for SiteAdmin defined using methods
    
public SiteAdminDao dao = new SiteAdminDaoImpl(); 
// Set Credentials 
private SiteAdmin st = null;

public void login() {
	 // login
   System.out.println("Please Enter Credientails for Login");
   System.out.println("Enter Email Id :");
   String email = Main.sc.next();
   System.out.println("Enter the password :");
   String password = Main.sc.next();
   
   try {
	    st = dao.login(email, password);
	    if(st != null) {
	    	System.out.println("\nYou Logined Seccussfuly!\n");
	    	this.options();
	    }
	} catch (SiteAdminException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		
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
	System.out.println("1. See the list of Tender Admins");
	System.out.println("2. See the list of Vendors");
	System.out.println("3. See the list of Projects");
	System.out.println("4. See the list of Tenders");
	System.out.println("5. Remove a Tender Admin");
	System.out.println("6. Remove a Vendor");
	System.out.println("7. Move to previous options\n");
	
	System.out.println("Enter a key from 1 to 7");
	
   int key =	Main.sc.nextInt();
   
   switch (key) {
	case 1: {
		
		this.tenderAdminList();
		break;
	}
   case 2: {
		
		this.vendorList();
		break;
	}
   case 3: {
		
		this.projectList();
		break;
	}
  case 4: {
		
		this.tenderList();
		break;
	} 
  case 5:{
	   
	   this.removeTenderAdmin();
	   break;
  }
  case 6:{
	   
	   this.removeVendor();
	   break;
  }
  case 7:{
	   String[] st = { "new"};
	   Main.main(st);
	   break;
  }
	default:
		System.out.println("\nInput is incorrect \n");
		this.options();
	}
   
   
}

public void tenderAdminList() {
	
	try {
	    List<TenderAdmin>  list =dao.getAllTenderAdmin();
	    if(!list.isEmpty()) {
	    	System.out.println("\nThe list of Tender Admin is follwoing :");
	    	list.forEach(t-> System.out.println(t));
	    }else {
	    	System.out.println("Oops! there is no Tender Admin registred yet");
	    }
	   
	} catch (SiteAdminException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}finally {
		 this.move();
	}
	
}



public void vendorList() {
	   try {
	     List<Vendor> list = dao.getAllVendors();
	     if(!list.isEmpty()) {
	    	 System.out.println("List of vendors is following :");
	    	 list.forEach(v -> System.out.println(v));
	     }else {
	    	 System.out.println("Oops! there is no vendor registered yet.");
	     }
	} catch (SiteAdminException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}finally {
		this.move();
	}
}



public  void projectList() {
     try {
	    List<Project>  list =	dao.getAllProjects();
	    if(!list.isEmpty()) {
	    	System.out.println("\nList of project is follwoing");
	    	list.forEach(p -> System.out.println(p));
	    }else {
	    	System.out.println("\nOops! there is no project listed yet.");
	    }
	} catch (SiteAdminException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		this.move();
	}
}


public void tenderList() {
    try {
	   List<Tender> list =	dao.getAllTenders();
	   if(!list.isEmpty()) {
		   System.out.println("\nList of all tenders is follwoing :");
		   list.forEach(t -> System.out.println(t));
	   }else {
		   System.out.println("\nOops! there is no tender listed yet.");
	   }
	} catch (SiteAdminException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}finally {
		this.move();
	}
}



public void removeTenderAdmin() {
	   System.out.println("Enter Tender Admin Id to remove :");
	   int tid = Main.sc.nextInt();
	   try {
	      String message =	dao.removeATenderAdmin(tid);
	      System.out.println(message);
	    } catch (SiteAdminException e) {
		  // TODO Auto-generated catch block
		  System.out.println(e.getMessage());
	   }finally {
		   this.move();
	   }
}


public void removeVendor() {
	 System.out.println("Enter Vendor Id to remove :");
	   int vid = Main.sc.nextInt();
	     try {
	         String message =	dao.removeAVendor(vid);
	         System.out.println(message);
	 } catch (SiteAdminException e) {
		      // TODO Auto-generated catch block
		      System.out.println(e.getMessage());
}finally {
		   this.move();
}
}


}
