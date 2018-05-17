import java.util.*;
import java.io.*;

public class erase{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		int a = Integer.parseInt(num); //Convert string to int

		String s = scan.nextLine();
		String arr[] = s.split("");

		String b = scan.nextLine();
		String brr[] = b.split("");
		
		if(a%2==0){
				if(s.equals(b)){
					System.out.println("Deletion succeeded");
				}
				else
		    		System.out.println("Deletion failed");		
		}
		else
		{
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i].equals(brr[i])){
					System.out.println("Deletion failed");
					return;
				}		
			}
			System.out.println("Deletion succeeded");
		}
	}
}