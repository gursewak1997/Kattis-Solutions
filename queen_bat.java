import java.util.*;
class queen {

  static int[] x = new int[128];          // solution
  static boolean[] a = new boolean[128];  // row free?
  static boolean[] b = new boolean[128];  // / diag free?
  static boolean[] c = new boolean[128];  // \ diag free?
  static boolean[][] boo;
  static int count = 0;
  static int N;

  static void PrintSoln() {
    count++;
  }

  static void gen (int col){
    for (int row=0;row<N;++row){
      if(boo[row][col]) continue;
      if(a[row] && b[row+col] && c[row-col+N]){
        x[col]=row;
        a[row] = b[row+col] = c[row-col+N] = false;   
        if(col==N-1)PrintSoln();
        else gen (col+1);
        a[row] = b[row+col] = c[row-col+N] = true;
      } 
    }
  }

  public static void main( String[] args ) {
    Scanner scan = new Scanner(System.in);
    String line[] = scan.nextLine().split(" ");
    int ll;
    a=new boolean[256];
    b=new boolean[256];
    c=new boolean[256];
    for(int i=0;i<256;i++){
      a[i]=b[i]=c[i]=true;
    }
    N=Integer.parseInt(line[0]);
    while(N!=0){
      boo=new boolean[256][256];

      ll=Integer.parseInt(line[1]);
      int row,col;
      for (int m=0;m<ll;m++){
        line=scan.nextLine().split(" ");
        row=Integer.parseInt(line[0]);
        col=Integer.parseInt(line[1]);
        boo[row][col]=true;
      }
      gen(0);
      System.out.println( count );
      line=scan.nextLine().split(" ");
      count=0;
      N=Integer.parseInt(line[0]);
    }
  }
}