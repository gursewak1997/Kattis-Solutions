import java.util.*;
public class kittenbudy {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int[] graph = new int[101];

int kitten = scan.nextInt();
scan.nextLine();

while (true)
	{
	String line = scan.nextLine();
	
	if (line.equals("-1"))
		break;

	String[] branch = line.split(" ");

	for(int i=1; i<branch.length;i++){
		graph[Integer.parseInt(branch[i])] = Integer.parseInt(branch[0]);

	}
	//System.out.println(graph[14]);
	}

while (true)
	{
	System.out.print(kitten + " ");
	if(graph[kitten]==0)
		break;
	kitten = graph[kitten];
	}

scan.close();
	}
}