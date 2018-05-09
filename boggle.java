import java.util.*;
import java.io.*;
public class boggle {
   
    static boolean[][] gone;

    public static void main(String[] args){
        int[] tally = {0, 0, 0, 1, 1, 2, 3, 5, 11};
        int[] x_ = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y_ = {-1, 0, 1, -1, 1, -1, 0, 1};
        char[][] matrix;
        Scanner scan=new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        String[] line = new String[num];

        for (int i = 0; i < num; i++) {
            line[i] = scan.nextLine();
        }
        scan.nextLine();
        int numBoards = scan.nextInt();
        scan.nextLine();
        while (numBoards-- > 0) {

            matrix = new char[4][4];
            for (int i=0; i<4; i++){
            matrix[i] = scan.nextLine().toCharArray();
            }

            gone = new boolean[4][4];

            Set<String> fou = new HashSet<String>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                for(int k=0;k<line.length;k++){
                String chr = line[k];
                if (fou.contains(chr)) 
                    continue;
                if (matrix[i][j] == chr.charAt(0)) {
                    if (calculate(i, j, chr, 1,x_,y_,matrix)) {
                        fou.add(chr);
                    }}}}
            }

            int cur_sco = 0;
            String big = "";
            for (String chr : fou) {
                if (chr.length() > big.length() ) {
                    big = chr;
                }
                if(chr.length() == big.length() && chr.compareTo(big) < 0){
                    big = chr;
                }
                cur_sco += tally[chr.length()];
            }
            System.out.println(cur_sco+" "+big+" "+fou.size());
            if (numBoards > 0) {
                scan.nextLine();
            }
            if(numBoards==0){
                break;
            }
        }

    }
    public static boolean calculate(int a, int b, String chr, int position,int [] x_,int [] y_,char[][] matrix) {
        if (position == chr.length()) 
            return true;
        
        boolean res = false;
        gone[a][b] = true;

        for (int ind = 0; ind < 8; ind++) {
            int nx = a + x_[ind];
            int ny = b + y_[ind];

            if (0 <= nx  && 0 <= ny && ny < 4 && nx < 4) {
                if(!gone[nx][ny]){
                if(matrix[nx][ny] == chr.charAt(position))
                res = (res || calculate(nx, ny, chr, position + 1,x_,y_,matrix));
            }
        }
        }
        gone[a][b] = false;
        return res;
    }
}