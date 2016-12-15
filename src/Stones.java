
public class Stones implements GridSetup {

	int rows;
	int columns;
	boolean isSetup = false;
	
	public Stones(){
		this.rows = 0;
		this.columns = 0;
	}
	public Stones(int numOfRows, int numOfColumns){
		while(!isSetup){
		if(numOfRows > 3 && numOfRows < 10 && numOfColumns > 3 && numOfColumns < 10){
		this.rows = numOfRows;
		this.columns = numOfColumns;
		this.isSetup = true;
		}
		else{
			System.out.println("choose a number of rows and columns between 3 and 10 (exclusive)");
		}
		}
	}
	
	public void setupGrid(){
		
	}
	
	public void setPlayerOne(){
		
	}
	
	public void setPlayerTwo(){
		
	}
	
	public void setAI(){
		
	}
	
	
}
