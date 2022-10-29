package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    public static int countClap(int number) {
        int result = 0;
        char [] num = String.valueOf(number).toCharArray();
        for (char c : num) {
            if (c == '3' || c == '6' || c == '9') {
                result += 1;
            }
        }
        return result;
    }
}
