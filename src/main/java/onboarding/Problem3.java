package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number + 1; i++) {
            int temp = i;
            while (temp != 0) {
                int singleDigit = temp % 10;
                temp = temp / 10;

                if (isThreeSixNine(singleDigit)) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    private static boolean isThreeSixNine(int number) {
        if (number == 3 || number == 6 || number == 9) {
            return true;
        }
        return false;
    }
}
