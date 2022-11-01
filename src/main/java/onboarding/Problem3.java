package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countThreeTimes(i);
        }
        return answer;
    }

    public static int countThreeTimes(int number) {
        String str = String.valueOf(number);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += checkThreeTimes(str.charAt(i));
        }
        return count;
    }

    public static int checkThreeTimes(char c) {
        if (c % 3 == 0 && c != '0') {
            return 1;
        }
        return 0;
    }
}
