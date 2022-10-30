package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String input = Integer.toString(i);
            answer = getAnswer(answer, input);
        }

        return answer;
    }

    private static int getAnswer(int answer, String input) {
        for (char c : input.toCharArray()) {
            int eachNumber = c - '0';
            if (is369(eachNumber)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean is369(int eachNumber) {
        if (eachNumber == 3 || eachNumber == 6 || eachNumber == 9) {
            return true;
        }
        return false;
    }
}
