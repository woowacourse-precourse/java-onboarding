package onboarding.feature3;

public class NumberSeparator {
    public static int[] getDigits(int number) {
        String numToStr = Integer.toString(number);
        int[] digitsOfNumber = new int[numToStr.length()];

        for (int i = 0; i < numToStr.length(); i++) {
            digitsOfNumber[i] = Character.getNumericValue(numToStr.charAt(i));
        }
        return digitsOfNumber;
    }
}
