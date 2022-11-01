package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
		for(int i = 1; i <= number; i++) {
			int j = i;
			while(j != 0) {
				int n = j%10;
				if(n == 3 || n == 6 || n == 9) {
					answer++;
				}
				else {}
				j /= 10;
			}
		}
        return answer;
    }
}
