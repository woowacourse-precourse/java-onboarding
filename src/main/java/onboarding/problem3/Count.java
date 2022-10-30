package onboarding.problem3;

public class Count {
    public static int count369(int number) {
        String stringNumber = Integer.toString(number);
        int result = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            char charDigit = stringNumber.charAt(i);
            int  intDigit = Character.getNumericValue(charDigit);
            if (isMultipleOfThree(intDigit)) {
                result += 1;
            }
        }
        return result;
    }
    public static boolean isMultipleOfThree(int number) {
        if (number % 3 == 0) {
            return true;
        }
        return false;
    }
}
