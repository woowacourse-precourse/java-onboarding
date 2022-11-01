package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number + 1; i++) {
            answer += checkNumber(i);
        }

        return answer;
    }
    private static int checkNumber(int number) {
        int count = 0;
        for (char c : makeString(number).toCharArray()) {
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }
        return count;
    }

    private static String makeString(int number) {
        return Integer.toString(number);
    }

}
