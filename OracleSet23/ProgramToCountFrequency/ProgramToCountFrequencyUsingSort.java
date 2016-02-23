import java.util.Scanner;

public class ProgramToCountFrequencyUsingSort
{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int[] array = new int[in.nextInt()];

		for(int i = 0; i < array.length; i++)
			array[i] = in.nextInt();
		java.util.Arrays.sort(array);
		if(array.length < 1)
			return;
		int j = array[0];
		int k = 1;
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] == j)
				k++;
			else
			{
				System.out.println(j+" "+k);
				j = array[i];
				k = 1;
			}
		}
		System.out.println(j+" "+k);


	}
}