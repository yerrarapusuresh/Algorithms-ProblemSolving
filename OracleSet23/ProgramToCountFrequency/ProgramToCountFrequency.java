import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class ProgramToCountFrequency
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] array = new int[size];

		for(int i = 0; i < size; i++)
			array[i] = in.nextInt();
		HashMap<Integer, Integer> hm = countFrequency(array);
		for(Map.Entry<Integer, Integer> e : hm.entrySet())
			System.out.println(e.getKey()+"  "+e.getValue());
	}

	public static HashMap<Integer, Integer> countFrequency(int[] array){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i : array)
		{
			if(hm.containsKey(i))
			{
				int val = hm.get(i);
				hm.put(i, val+1);
			}
			else
				hm.put(i, 1);
		}

		return hm;
	}
}

