package com.iupui.dsoundar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchPDFfiles {
	static String line = null;
	static BufferedReader buffer = null;
	static BufferedWriter bwrite = null;
	static FileWriter fw = null;
	static boolean found = false;
	static FileReader fr = null;
	static ArrayList<String> alist = new ArrayList<String>();
	static String path = "C:/Users/ajsiv/Documents/Predictive/TextFiles";
	static boolean stop = false;
	
	public static void main(String[] args) throws IOException{
		
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		System.out.println("!! To exit the program, type quit");
		while(!stop){
			System.out.println("Enter your search keyword: ");
			Scanner scanner = new Scanner(System.in);
			String key = scanner.nextLine();
			if(!key.matches("quit")){
				System.out.println("Searching for documents with the keyeowrd " + key);
				
				for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  fr = new FileReader(listOfFiles[i]);
				    	  buffer = new BufferedReader(fr);
				    	 
				    	  while ((line = buffer.readLine())!= null){
				    		  if(line.contains(key)){
				    			  found=true;
				    		  }
				    	  }
				    	  if (found){
				    		  alist.add(listOfFiles[i].toString());
				    	  }
				    	  found = false;
				      }
				    }
				    for(String files:alist){
				    	System.out.println(files);
				    }
				    scanner.close();
			}else{
				stop = true;
			}
		}
	}
}
