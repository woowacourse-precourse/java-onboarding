package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    public static int count369(int number) {
        int result = 0;

        String numStr = String.valueOf(number);
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if((int)ch == 3 || (int)ch == 6 || (int)ch == 9) {
                result++;
            }
        }

        return result;
    }
}
