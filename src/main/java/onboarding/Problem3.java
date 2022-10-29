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
        for (int j = 0; j < intToString(number).length(); j += 1) {
            count = addCount(number, j, count);
        }
        return count;
    }

    public static boolean isNumberHas369(int number, int j) {
        return intToString(number).charAt(j) == '3' || intToString(number).charAt(j) == '6' || intToString(number).charAt(j) == '9';
    }

    public static String intToString(int number) {
        return number + "";
    }

    public static int addCount(int checkingNumber, int checkedNumber, int count) {
        if (isNumberHas369(checkingNumber, checkedNumber)) {
            count += 1;
        }
        return count;
    }


}