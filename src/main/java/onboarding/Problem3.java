package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 0; i <= number; i++) {
            String s = String.valueOf(i);
            for(int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
                    answer++;
                }
            }
        }

        return answer;
    }
}
