package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int convertNumber;

        convertNumber = Integer.parseInt(convertCountingNumbersToString(number));

        return convertNumber;
    }

    public static String convertCountingNumbersToString(int number) {
        String convertString = "";

        for (int i = 1; i <= number; i++) {
            convertString += i;
        }

        return convertString;
    }
}
