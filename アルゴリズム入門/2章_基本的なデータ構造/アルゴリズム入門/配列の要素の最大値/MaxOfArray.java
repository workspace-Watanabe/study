package アルゴリズム入門.配列の要素の最大値;

import java.util.Random;

public class MaxOfArray {

	static int maxOf(int[] humans) {
		int max = humans[0];

		for(int i = 1; i < humans.length; i++) {
			if(humans[i] > max) {
				max = humans[i];
			}
		}
		return max;
	}


	public static void main(String[] args) {
		Random random = new Random();

		System.out.println("身長の最大値を求めます");

		int number = random.nextInt(30);

		int[] humans= new int[number];

		for(int i=0; i < humans.length; i++) {
			humans[i] = random.nextInt(90);
			System.out.println("height[" + i +  "]" + humans[i] );
		}
		System.out.println(humans[0]);
		System.out.println("最大値は" + maxOf(humans) + "です");
		System.out.println("" + maxOf(humans) + "です");
	}
}
