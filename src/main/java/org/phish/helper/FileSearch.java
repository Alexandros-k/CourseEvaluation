package org.phish.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.phish.model.Verb;

public class FileSearch {

	private List<String> foundVerbs= new ArrayList<>();
	
	 public List<String> parseFile(String fileName,List<Verb> searchVerbs) throws FileNotFoundException{
	        Scanner scan = new Scanner(new File(fileName));
	        while(scan.hasNext()){
	            String line = scan.nextLine().toLowerCase().toString();
	            for (Verb verbName : searchVerbs) {
	            	if(line.contains(verbName.getName())){
		                foundVerbs.add(verbName.getName());
		                
		            }
				}
	            
	        }
	    return foundVerbs;
	 }
}
	
