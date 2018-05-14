import java.io.*;
import java.util.*;
public class crypto{

	public static void main(String[] args){

		Scanner scan=new Scanner(System.in);
		String s = scan.nextLine();
		String array[] = s.split("");  //Putting string as an array

		int count = 0;
		int j=0;

		for(int i=0;i<(array.length/3);i++){
			if(!array[j].equals("P")){
				count++;
			}
			if(!array[j+1].equals("E")){

				count++;
			}
			if(!array[j+2].equals("R")){
				count++;
			}
			j = j+3;
		}
		System.out.println(count);
	}
}