
import java.io.*;
import java.util.*;

public class functionalfun{

	public static void main(String[] args){

		Scanner scan=new Scanner(System.in);
		while(scan.hasNextLine()){
			String s = scan.nextLine();
			String array[] = s.split(" ");
			int len;
			len = array.length;
			String domain[] = new String[len-1];
			for(int i=1;i<len;i++){
				domain[i-1] = array[i];
			}

			String p = scan.nextLine();
			String array2[] = p.split(" ");
			int len2;
			len2 = array2.length;
			String codomain[] = new String[len2-1];
			for(int i=1;i<len2;i++){
				codomain[i-1] = array2[i];
			}

			int num = Integer.parseInt(scan.nextLine());
			String pa[][] = new String[num][2];
			for(int i=0;i<num;i++){
				String st = scan.nextLine();
				String pairs[] = st.split(" ");
				pa[i][0] = pairs[0];
				pa[i][1] = pairs[2];
			}
			calculate(domain,codomain,pa,num);
		}
	} 

public static void calculate(String[] a, String[] b, String[][] c, int num){
		
	boolean injective = true;
	boolean surjective = true;
	boolean function = true;
	String [] arr = new String[num];
	for (int i =0;i<num;i++){
		for(int j=i+1;j<num;j++){
			

			if (c[i][0].equals(c[j][0])){
			if (!c[i][1].equals(c[j][1])){
				function = false;
				break;
			}
			}
		}	
	}
	if(function){
		for (int i =0;i<num;i++){
		for(int j=i+1;j<num;j++){
			if (c[i][1].equals(c[j][1])){
			if (!c[i][0].equals(c[j][0])){

				injective = false;
				break;
			}
			}
		}
		}
	}
	if (function){
		for(int i=0;i<num;i++){
			
			arr[i] = c[i][1];
		}
		if(isSubset(arr,b,num,b.length))
			surjective = true;
		else
			surjective = false;	
	}
	if (function)
			{
				if (injective)
				{
					if (surjective)
						System.out.println("bijective");
					else
						System.out.println("injective");
				}
				else
				{
					if (surjective)
						System.out.println("surjective");
					else
						System.out.println("neither injective nor surjective");
				}
			}
			else
			 System.out.println("not a function"); 
	}

	 static boolean isSubset(String arr1[], String arr2[], int m, int n)
    {
        int i = 0;   // From https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
        int j = 0;
        for (i=0; i<n; i++)
        {
            for (j = 0; j<m; j++)
            {
               if(arr2[i].equals(arr1[j]))
                  break;
            }
            if (j == m)
               return false;
        }
        return true;
    }

	
}