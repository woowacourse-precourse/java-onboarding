package onboarding.problem3;

public class ThreeSixNineGame {
    private static final String THREE = "3";
    private static final String SIX = "6";
    private static final String NINE = "9";
    private final int number;

    public ThreeSixNineGame(int number) {
        this.number = number;
    }

    public String toString(int number) {
        return String.valueOf(number);
    }

    public int hasThreeSixNine(String number, int length) {
        int clapCount = 0;
        for (int i = 0; i < length; i++) {
            if (number.startsWith(THREE, i)) {
                clapCount += 1;
            }
            if (number.startsWith(SIX, i)) {
                clapCount += 1;
            }
            if (number.startsWith(NINE, i)) {
                clapCount += 1;
            }
        }
        return clapCount;
    }

    public int getStringLength(String number) {
        return number.length();
    }

    public int runGame() {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            String stringNumber = toString(i);
            int length = getStringLength(stringNumber);
            result += hasThreeSixNine(stringNumber, length);
        }
        return result;
    }
}
