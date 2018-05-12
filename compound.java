import java.util.*;
import java.io.*;

public class compound{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		PriorityQueue<String> q=new PriorityQueue<String>();
		String s = "";
		while(scan.hasNextLine()){
			s += scan.nextLine()+" ";

		}
		System.out.println(s);
		String arr[] = s.split(" ");

		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(!q.contains(arr[i]+arr[j])){
					q.add(arr[i]+arr[j]);
				}
				if(!q.contains(arr[j]+arr[i])){
					q.add(arr[j]+arr[i]);
				}
			}
		}
		while(!q.isEmpty()){
			System.out.println(q.poll());
	    }
	}
}