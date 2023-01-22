package app;

import java.util.Scanner;

import usecase.SiteAdminUseCase;
import usecase.TenderAdminUseCase;
import usecase.VendorUseCase;


public class Main {
    // this is main class of application
	// this is the entry point.
	public static  Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome");
		
		// option - SiteAdmin , ProposalAdmin, Vendor
		 System.out.println("\nEnter Number :");
        System.out.println("1 for SiteAdmin");	
        System.out.println("2 for Tender Administatrator ");	
        System.out.println("3 for Vendor");	
        
        int num = sc.nextInt();
        
        switch (num) {
		case 1: {
			
		    	siteAdmin();
		    	break;
		}
		case 2: {
			
	    	tendorAdmin();
	    	break;
	    }
     case 3: {
			
	    	vendor();
	    	break;
	    }
		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}
       
	}
	
	
	public static void siteAdmin() {
		   //create a instance of SiteAdminUseCase class
		   SiteAdminUseCase st = new SiteAdminUseCase();
		   
		   st.login();   
		   
		    
		  
	}

	public static void tendorAdmin() {
		   // create a instance of tenderAdminUseCase class
		   TenderAdminUseCase pAdminUseCase = new TenderAdminUseCase();
		   
		   
		  
		   System.out.println("\nEnter Option as 1 & 2 ");
		   
		   
		   System.out.println("1 for Registeration ");
		   System.out.println("2 for Login");
		   
		   
		   int key = sc.nextInt();
		   
		   
		   switch (key) {
		case 1: {
			
			pAdminUseCase.register();
			break;
		}
    	case 2: {
			
			pAdminUseCase.login();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}
	
	public static void vendor() {
		// create a instance of ProposalAdminUseCase class
		  VendorUseCase vendor = new VendorUseCase();
		   
		   
		  
		   System.out.println("\nEnter Option as 1 & 2 ");
		   
		   
		   System.out.println("1 for Registeration ");
		   System.out.println("2 for Login");
		   
		   
		   int key = sc.nextInt();
		   
		   
		   switch (key) {
		case 1: {
			
		     vendor.register();
			break;
		}
 	case 2: {
			
			vendor.login();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}
	
	
	
	
}
