package ourClasses;

import java.util.LinkedList;

public class Sites {
	
	public static boolean canCollect = true; 
	public static LinkedList<Reading> readings = new LinkedList<Reading>();
	public LinkedList<String> ids = new LinkedList<String>();
	
	
	//a Site should have a siteID and its list of readings 
	//Constructor
	 public Sites(String siteID) {
	 // readings = new LinkedList<Reading>(); //iniaiize empty Linkedlist of Reading objects
	  ids.add(siteID);
	}
	
     /**Method return the status of a Site for collection
      * 
      * @return Boolean status of collection for a Site
      */
	 public static boolean checkCollStatus() {
		 return canCollect;	 
	 }
	 
	/** Method that turns on site collection for a Site 
	 **/
	 
	public void turnOnStatus() {
	if (canCollect == false) {
	canCollect = true;
	}
	}
	
	/** Method that turns off site collection for a Site 
	 **/
	public void turnOffStatus() {
		if (canCollect == true) {
			canCollect = false;
		}
	}
	
	/** Method that takes in parameters and adds it to its LinkedList of readings 
	 * 
	 * precondition: collection status of Site must be true
	 **/
	public static void addAReading(String studyName, String studyId, String id, String rdgType, String rdgID, double rdgValue, String rdgDate){
	 if(checkCollStatus() == true) {
		 readings.add(new Reading(studyName,studyId,id,rdgType,rdgID,rdgValue,rdgDate));
	 }
	 else {
		 System.out.println("Sorry, this site is not accepting data for collection");
	 }
	}
	
	/**
	 * Method that displays all the readings for a given site
	 * @return String the list of readings
	 **/
	public static String displayRdgs() {
		String list = "";
		for(Reading rdgs : readings)
	        {	            	
	            	list = list + rdgs.toString();
	  
	        }
		
		return list;
	}
		
	
	public static void main(String[] args) {

        Sites s = new Sites("12345"); 
        //Sites s2 = new Sites("12555");
        s.addAReading("Midwest USA Study", "450","12345","temprature","974",102.00,"1515354694451");
        s.addAReading("Eastern USA Study", "400","12345","temprature","984",99.00,"1515354694489");
        
        
        System.out.println(s.displayRdgs());
	        
		
	}

}