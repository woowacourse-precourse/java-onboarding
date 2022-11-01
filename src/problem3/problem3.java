package problem3;

public class problem3 {
	public static int solution(int number) {
		int result = 0;
		for(int i=1; i<=number; i++) {
			int current = i;
			int temp = result;
			while(current != 0) {
				if(current%10==3 || current%10==6||current%10==9) result++;
				current /= 10;
			}
		}
		return result;
	}
	

}
