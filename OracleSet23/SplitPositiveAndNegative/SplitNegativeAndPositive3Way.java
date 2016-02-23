import java.util.Scanner;

public class SplitNegativeAndPositive3Way
{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int[] array = new int[in.nextInt()];

		for(int i = 0; i < array.length; i++)
			array[i] = in.nextInt();

		splitNegativeAndPositive3Way(array);
		for(int i : array)
			System.out.print(i);
		System.out.println();
	}

	public static void splitNegativeAndPositive3Way(int[] array)
	{
		int lt = 0;
		int gt = array.length-1;
		int p = 0;
		int i = 0;
		while(i <= gt)
		{
			if(array[i] < p)
				swap(i++, lt++, array);
			else if(array[i] > p)
				swap(gt--, i, array);
			else i++;
		}
	}

	public static void swap(int i, int j, int[] array){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

