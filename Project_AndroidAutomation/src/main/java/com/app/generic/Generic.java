package com.app.generic;
import org.json.simple.JSONArray;
public class Generic {
	public String filePath="";
	public JSONArray JSONArray;
	
	public Generic() {
		
	}
	
	/*To print the log/test result messages into text file/json file*/ 
	public static void logMessage(LogStatus status,String msg) {
			System.out.println("Status:"+status+" Msg:"+msg);
			
	}
	
}
