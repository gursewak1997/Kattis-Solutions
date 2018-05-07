//Gursewak Singh
//V00875106
import java.io.*;
import java.util.*;

public class arbitrage{

	public static void main(String[] args){
		Map<String,Integer> curname = new HashMap<String,Integer>();
		double dist[][] = new double [300][300];
		int n,m;
		Scanner scan=new Scanner(System.in);

		while(scan.hasNextLine()){
		String name,c1,c2;
		n = Integer.parseInt(scan.nextLine().trim());
		System.out.println(n);
		if(n==0){
			return;
		}
		curname.clear();
		int a,b,c,i1,i2;
		String str = scan.nextLine();
		String array[] = str.split(" ");
		//System.out.println(array[0]);

		for(int i=0;i<n;++i){
			curname.put(array[i],i);
			for(int j =0;j<n; ++j){
			 	dist[i][j]=0.0;
			}
            	dist[i][i] = 1.0;

		}
		int con = Integer.parseInt(scan.nextLine());
		//System.out.println(con);
		for(int i=0;i<con;++i){
			String goo=scan.nextLine();
			 c1 = goo[]
			 c2 = scan.next();
			 String[] temp = scan.next().split(":");
			 //System.out.println(temp[0]);
			 a=Integer.parseInt(temp[0]);
			 b=Integer.parseInt(temp[1]);
			 i1 = curname.get(c1);
			 i2 = curname.get(c2);
			 dist[i1][i2] = Math.max(dist[i1][i2],(double)b/(double)a);
		}
		for(int k=0;k<n;++k)
            for(int i=0;i<n;++i)
                for(int j=0;j<n;++j)
                    dist[i][j]=Math.max(dist[i][j],dist[i][k]*dist[k][j]);

         boolean flag = true;
        for(int i=0;i<n;++i) if(dist[i][i]>1.0) flag = false;
        	if(flag){
        		System.out.println("Ok");

        	}
        	else
        		System.out.println("Arbitrage");

        	String adff = scan.nextLine();
        }
	}	
}
