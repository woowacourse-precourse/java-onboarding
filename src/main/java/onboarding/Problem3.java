package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (!verifyException(number)) {
            return -1;
        }
        return countClap(number);
    }

    private static int countClap(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String stringNumber = Integer.toString(i);
            String[] splitNumber = stringNumber.split("");

            for (int j = 0; j < splitNumber.length; j++) {
                if (isClap(splitNumber, j)) {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    private static boolean isClap(String[] splitNumber, int j) {
        return (splitNumber[j].contains("3") || splitNumber[j].contains("6") || splitNumber[j].contains("9"));
    }

    private static boolean verifyException(int number) {
        return (number >= 1 && number <= 10000);
    }
}
