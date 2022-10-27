package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countThreeAndSixAndNine(number);
    }

    public static int countThreeAndSixAndNine(int number) {
        int count = 0;
        String convertString = convertCountingNumbersToString(number);

        for (int i = 0; i < convertString.length(); i++) {
            if (convertString.charAt(i) == '3'
                    || convertString.charAt(i) == '6'
                    || convertString.charAt(i) == '9') {
                count++;
            }
        }

        return count;
    }

    public static String convertCountingNumbersToString(int number) {
        String convertString = "";

        for (int i = 1; i <= number; i++) {
            convertString += i;
        }

        return convertString;
    }
}