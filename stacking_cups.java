import java.util.*;
import java.io.*;

public class cups{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
        int number=scan.nextInt();
        TreeMap<Integer,String> map=new TreeMap<Integer,String>();

		for(int i=0;i<number*2;i++){

			if(scan.hasNextInt()){
				int a = scan.nextInt();
				map.put(a/2,scan.next());
			}
			else if(scan.hasNext()){
				String s=scan.next();
				int a=scan.nextInt();
				map.put(a,s);
			}
		}		
        for(Map.Entry m:map.entrySet()){  //Way to print value from treemap
  		    System.out.println(m.getValue()); 
        }
    }
}
