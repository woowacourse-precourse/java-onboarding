package onboarding;

public class Problem3 {
    public static int solve(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }

        return answer;
    }

    public static int countClap(int number) {
        int count = 0;
        String stringNumber = Integer.toString(number);

        for (int i = 0; i < stringNumber.length(); i++) {
            if (judge369(stringNumber.charAt(i) - '0')) {
                count++;
            }
        }

        return count;
    }

    public static boolean judge369(int digit) {
        return digit != 0 && digit % 3 == 0;
    }

    public static int solution(int number) {
        return solve(number);
    }
}
