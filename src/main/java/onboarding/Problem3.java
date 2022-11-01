package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }


    private static int countClap(int endNumber) {
        int result = 0;

        for (int number = 1; number <= endNumber; number++) {
            String strNumber = String.valueOf(number);

            for (int digit = 0; digit < strNumber.length(); digit++) {
                int digitNumber = Integer.parseInt(String.valueOf(strNumber.charAt(digit)));
                if (digitNumber % 3 == 0 && digitNumber != 0) {
                    result++;
                }
            }

        }

        return result;
    }
}
