package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
String Temp;
		
		for (int i = 1; i-1 <number; i++) {
			Temp = Integer.toString(i);
			for (int j = 0; j < Temp.length(); j++) {
				if (Temp.charAt(j) == '3' || Temp.charAt(j) == '6' || Temp.charAt(j) == '9') {
					answer++;
				}
			}
		}
        return answer;
    }
}
