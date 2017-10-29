package joy.cse.ru;


public class AnalyseBabyName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnalyseBabyName babyNames = new AnalyseBabyName() ;
		babyNames.testAllMethod() ; 

	}

	public void printName(){
		FileResource  fr = new FileResource() ; 
		
		for(CSVRecord  f : fr.getCSVParser(false)){
			
			int numBornBaby = Integer.parseInt(f.get(2)) ;
			
			if(numBornBaby <= 100){
				System.out.println("Name: " + rec.get(0) + ", Gender: " + rec.get(1) + ", Num Baby born: " + rec.get(2));
				
			}
			
			
		}
		
		
	}
	
	void testAllMethod(){
		 printNAmes() ; 
		
	}
}


