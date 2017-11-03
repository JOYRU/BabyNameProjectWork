package joy.cse.ru;
import org.apache.commons.csv.*;
import edu.duke.*;

import edu.duke.FileResource;

import java.io.File;
//import java.text.DecimalFormat;



public class AnalyseBabyName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnalyseBabyName babyNames = new AnalyseBabyName() ;
		babyNames.testAllMethod() ; 

	}

	/*public void printName(){
		FileResource  fr = new FileResource() ; 
		
		
		for(CSVRecord  f : fr.getCSVParser(false)){
			
			int numBornBaby = Integer.parseInt(f.get(2)) ;
			
			if(numBornBaby <= 100){
				System.out.println("Name: " + f.get(0) + ", Gender: " + f.get(1) + ", Num Baby born: " + f.get(2));
				
			}
			
			
		}
		
		
	}*/
	
	public void printName(){
		FileResource fr = new FileResource() ;
		
		for(CSVRecord f : fr.getCSVParser(false)){
			
			int numBornBaby = Integer.parseInt(f.get(2)) ;
			
			if(numBornBaby<=100)
				 System.out.println("Name : " + f.get(0) +  " Gender : " + f.get(1) + "Number of Born : "  + f.get(2)  ) ;
			
		}
	}
	
	
	public void totalBirths(){
		
		FileResource fr = new FileResource() ;
		
		int totalBirth = 0 ;
		int maleBirth = 0 ;
		int femaleBirth = 0 ;
		
		/*
		for(CSVRecord f : fr.getCSVParser(false)){
			int numBaby = Integer.parseInt(f.get(2) ) ;
			
			if(f.get(1).equals('M'))
				 maleBirth += numBaby ;
			else
				femaleBirth += numBaby ;	
			
		}*/
		
		for(CSVRecord f : fr.getCSVParser(false) ){
			
			int numBaby = Integer.parseInt(f.get(2)) ;
			
			if(f.get(1).equals('M'))
				 maleBirth +=numBaby ;
			else
				femaleBirth += numBaby ;
			
		}
		
		totalBirth= maleBirth + femaleBirth;
		System.out.println("Total births: " + totalBirth);
		System.out.println("Total male births: " + maleBirth);
		System.out.println("Total female births: " + femaleBirth);
		
	}
	
	/*public int getRank(int year , String name , String gender){
		
		String fileName = "data/yob" + String.valueOf(year) + ".csv" ;
		int rank = 0 ;
		
		FileResource fr = new FileResource(fileName) ;
		
		for(CSVRecord f: fr.getCSVParser(false)){
			
			  if(f.get(1).equals(gender))
				   rank++;
			  if(f.get(0).equals(name))
				   return rank ; 
			  
		}
		
		
		
		return -1 ;
		
	}
	*/
	
	public int getRank(int year , String name , String gender ){
		
		String fileName = "data/yob" + /*String.valueOf(year)*/ year + ".csv" ; 
		int rank = 0 ;
		FileResource fr = new FileResource(fileName) ;
		for(CSVRecord f : fr.getCSVParser(false)){
			if(f.get(1).equals(gender))
				rank++ ; 
			if(f.get(0).equals(name))
				return rank ; 
		}
		
		
		
		return -1 ;
	}
	
	
	public int yearOfHighestRank(String name , String gender){
		
		int highRank = Integer.MAX_VALUE;
		int currRank ;
		int highRankConYear = -1 ;
		
		for(int year = 1880 ; year<=2017 ; year++){
			
			currRank = getRank(year , name , gender) ;
			if(currRank < highRank)
				 highRank = currRank ; 
			     highRankConYear = year ;
		}
		
		
		
		return highRankConYear ; 
		
	}
	
	
	
	public String getNAme(int year ,int rank, String gender){
		   String filename = "data/yob" + String.valueOf(year)+".csv" ;
		   FileResource fr = new FileResource(filename) ;
		   int currrank = 0 ;
		   
		   
		   for(CSVRecord f : fr.getCSVParser(false)){
			   
			   if(f.get(1).equals(gender))
				   currrank++;
			   
			   if(currrank==rank)
				   return f.get(0) ;
			   
				   
		   }
		 
		    return "No Name" ;
	} 
	
	
	public double averageRank(String name , String gender){
		DirectoryResource dr = new DirectoryResource();
		//boolean found = false ; 
		int currRank = 0;
		int totalFound = 0;
		int totalNumberOfRanks = 0;
		double ave ;
		
		
		for(File fr : dr.selectedFiles()){
			totalFound++;
			currRank = 0; 
			FileResource frr = new FileResource() ;
			
			
			for(CSVRecord f :frr.getCSVParser(false) ){
				if(f.get(1).equals(gender))
					currRank++;
				if(f.get(0).equals(name))
					break;
				
			}
			totalNumberOfRanks = totalNumberOfRanks + currRank ;
			
			
		}
		
		if( totalNumberOfRanks==0)
			return -1.0 ;
		else{
			ave = ( totalNumberOfRanks / totalFound) ;
			return ave ;
			
		}
		
	}
	
	public int getTotalBirthsRankedHigher(int year , String name , String gender ){
		
		String fileName = "data/yob" + year + ".csv" ;
		FileResource fr = new FileResource(fileName) ;
		int totalRank = 0 ;
		for(CSVRecord f:fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(f.get(2)) ;
			if(f.get(1).equals(name))
				break ;
			if(f.get(1).equals(gender))
				totalRank += numBorn ;
			
			
		}
		return totalRank ;
	}
	
	
	
	void testAllMethod(){
		 printName() ; 
		
	}
}



