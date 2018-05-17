//Gursewak Singh
import java.util.*;
import java.io.*;
public class egg{

public static void main(String[] args){
Scanner scan = new Scanner(System.in);
		
while(scan.hasNext()){
	int number =Integer.parseInt(scan.nextLine());
	TreeMap<String, ArrayList<String>> tmap= new TreeMap<>();

	ArrayList<String> food = new ArrayList<>();

	if(number == 0){
		break;
	}

	for(int i =0; i<number; i++){
		String person = scan.nextLine();
		String[] a =person.split(" ");
		
		for(int j=1;j<a.length;j++){
			if(tmap.containsKey(a[j])==false){
				ArrayList<String> item = new ArrayList<>();
				item.add(a[0]);
				tmap.put(a[j], item);
				food.add(a[j]);
			
			}
		else{
			ArrayList<String> item = tmap.get(a[j]);
            item.add(a[0]);
            tmap.put(a[j] , item);
		}
		}
	}

	sort(food);
 

	for(int i = 0; i < food.size(); i++){
		System.out.print(food.get(i));
		ArrayList<String> person = tmap.get(food.get(i));
	    sort(person);
	    for (int j = 0; j < person.size(); j++){
	        System.out.print(" " + person.get(j));
	        }
	        System.out.println();
	        }

   	     System.out.println();
    }

	scan.close();


	}

	public static void sort(ArrayList<String> a){
		 for (int i = 0; i < a.size(); i++) {

           for (int j = 0; j < a.size() - i - 1; j++) {

               if (a.get(j).compareTo(a.get(j + 1)) > 0) {

                  String temp = a.get(j);
                  a.set(j, a.get(j + 1));
                  a.set(j + 1, temp);

        }
    }
	}
}
}
