package problem5;

import java.util.Arrays;

public class Problem5 {
	public static String solution(int i) {
		
		int[] result = new int[9];
		int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		
		for(int j=0;j<won.length;j++) {
			int answer = i/won[j];
			i = i%won[j];
			result[j] = answer;
		}

		return Arrays.toString(result);

	}
	
}
