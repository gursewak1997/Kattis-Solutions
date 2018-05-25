import java.util.*;

class tower {

   public static void main ( String[] args ) {

      // read data
      Scanner in = new Scanner( System.in );
      int[] s = new int[8];
      for (int i=0; i<8; ++i) s[i] = in.nextInt();

      // process data 0 <= i < j < k < 6
      for (int i=0; i<6; i++)
      for (int j=i+1; j<6; j++)
      for (int k=j+1; k<6; k++) {
         if (s[i]+s[j]+s[k] == s[6]) {
         	
            boolean[] b = new boolean[6];
            b[i] = b[j] = b[k] = true;
            int[] ss = {s[i],s[j],s[k]};
            Arrays.sort( ss );
            System.out.print( ss[2]+" "+ss[1]+" "+ss[0]+" " );
            for (int t=0,u=0; t<6; ++t) if (!b[t]) ss[u++] = s[t];
            Arrays.sort( ss );
            System.out.println( ss[2]+" "+ss[1]+" "+ss[0] );
         }
      }
   }
}