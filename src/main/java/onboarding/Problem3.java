package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            String str = String.valueOf(i);
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    answer++;
                }
            }
        }

        return answer;
    }
}
