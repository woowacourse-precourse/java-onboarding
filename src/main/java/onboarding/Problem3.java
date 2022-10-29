package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i += 1) {
            count = changeCountByNumberExists(i, count);
        }
        return count;
    }

    public static int changeCountByNumberExists(int number, int count) {
        for (int index = 0; index < intToString(number).length(); index += 1) {
            count = changeCountByDigitNumber(number, index, count);
        }
        return count;
    }

    public static int changeCountByDigitNumber(int checkingNumber, int index, int count) {
        if (isNumberHas369(checkingNumber, index)) {
            count += 1;
        }
        return count;
    }

    public static boolean isNumberHas369(int number, int index) {
        return intToString(number).charAt(index) == '3' || intToString(number).charAt(index) == '6' || intToString(number).charAt(index) == '9';
    }

    public static String intToString(int number) {
        return number + "";
    }

}