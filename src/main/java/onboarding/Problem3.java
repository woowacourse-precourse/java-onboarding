package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    private static int countClap(int num) {
        int result = 0;
        String target = String.valueOf(num);
        for (int i = 0; i < target.length(); i++) {
            result += validate369(target.charAt(i));
        }
        return result;
    }

    private static int validate369(char c) {
        if (c == '3' || c == '6' || c == '9') {
            return 1;
        }
        return 0;
    }

}
