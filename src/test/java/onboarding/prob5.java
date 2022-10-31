package onboarding;

import java.util.*;

public class prob5 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		solution(sc.nextInt());
	}

	public static int[] solution(int money) {
		int result[] = new int[9];
		
		int fir = 50000;
		int sw = 0;
		
		for (int i = 0; i < result.length; i++) {
			result[i] = money / fir;
			money = money % fir;
			
			if(sw==0) {
				sw=1;
				fir /= 5;
			}
			else if (sw == 1 && money < 10) {
				fir /= 10;
			}
			else {
				sw = 0;
				fir /= 2;
			}
		}
		System.out.print(Arrays.toString(result));
		return result;
	}	
}
