import java.util.Scanner;

public class SplitNegativeAndPositive
{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int[] array = new int[in.nextInt()];

		for(int i = 0; i < array.length; i++)
			array[i] = in.nextInt();
		splitThePositiveAndNegative(array);
		for(int i : array)
			System.out.print(i);
		System.out.println();
	}

	public static void splitThePositiveAndNegative(int[] array)
	{
		for(int i = 0, j = 0; i < array.length; i++)
			if(array[i] < 0)
			{
				swap(array, i, j++);
			}
	}

	public static void swap(int[] array, int i, int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}