import java.util.*;
import java.io.*;

public class bishop{
	public static void main(String[] args){

	Scanner scan = 	new Scanner(System.in);
	while(scan.hasNextLine()){
		
		int s = Integer.parseInt(scan.nextLine());
		if(s==1){
			System.out.println("1");
			
		}
		else{
			System.out.println((2*s)-2);
		}
	}		


	}
}