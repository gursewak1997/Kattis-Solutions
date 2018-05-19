import java.util.*;
public class korni{
	public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	String a = s.nextLine();
    String array[] = a.split(" ");

	int[] nums = new int[4];
	nums[0] = Integer.parseInt(array[0]);
	nums[1] = Integer.parseInt(array[1]);
	nums[2] = Integer.parseInt(array[2]);
	nums[3] = Integer.parseInt(array[3]);

	

	Arrays.sort(nums);

	System.out.println(nums[0] * nums[2]);

	


    }
}