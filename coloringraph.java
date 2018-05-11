//Gursewak Singh
import java.util.*;
import java.io.*;

public class graph {
    public static int smallest(boolean[][] boo, int ind, int[] same, int next) {

    int n = boo.length;

    if (ind == n)
      return 0;

    int best = Integer.MAX_VALUE;
    a:  for (int m = 1; m < next; m++) {
        for (int i = 0; i < ind; i++)
        if (boo[ind][i])
          if(same[i] == m)
            continue a;
      same[ind] = m;
      best = Math.min(best, smallest(boo, ind + 1, same, next));
    }
    same[ind] = next;
    best = Math.min(best, 1 + smallest(boo, ind + 1, same, next + 1));
    return best;
  }

  public static void main(String[] args) {

    Scanner scan=new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());

    boolean[][] boo = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String[] line = scan.nextLine().split(" ");
      for(int m=0;m<line.length;m++){
        String s = line[m];
        int j = Integer.parseInt(s);
        boo[i][j] = true;
        boo[j][i] = true;
      }
    }
    System.out.println(smallest(boo, 0, new int[n], 1));
  }
}