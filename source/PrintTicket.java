import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintTicket extends ShoppingCart<Ticket>{
    
    public String PrintingTicket() {
   
    
    	 try {
             file = new FileWriter("JSONReader.txt");
             JSONReaderLog("Thank you for your purchase to see"+getShow() );
             JSONReaderLog("The show you have paid to see will be at "+getLocation() );
             JSONReaderLog("And finally you paid" + getPrice() + "for your ticket!");
             JSONReaderLog("Thanks again for purchasing at THE_247_PROJECT. Have a nice day and call (***)-***-**** if you have any issues!");
         } 
    	 catch (IOException e)
    	 {
             e.printStackTrace();
         }
    	 finally
    	 {
    		 try 
    		 {
    			file.flush();
    			file.close();
    		 }
    		 catch (IOException e)
    		 {
    			 e.printStackTrace();
    		 }
    	 }

}
