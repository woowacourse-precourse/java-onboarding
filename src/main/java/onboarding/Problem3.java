package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
            	char check = str.charAt(j);
                if (check == '3' || check == '6' || check == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
