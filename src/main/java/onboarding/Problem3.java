package onboarding;

public class Problem3 {
    public static int solution(int number) {
		int answer = 0;
        
		for (int i=1; i<number+1; i++) {
			String[] strArray = String.valueOf(i).split("");
			for (String str : strArray) {
				if (str.equals("3") || str.equals("6") || str.equals("9")) {
					answer += 1;
				}
			}
		}
		return answer;
    }
}