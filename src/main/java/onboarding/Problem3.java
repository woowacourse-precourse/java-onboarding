package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            String numberString = Integer.toString(i);
            sum += checkString(numberString);
        }
        return sum;
    }

    public static int checkString(String numberString) {
        int sum = 0;
        for (int i = 0; i < numberString.length(); i++) {
            char check = numberString.charAt(i);
            if (isNumber_369(check)) {
                sum++;
            }
        }
        return sum;
    }

    public static boolean isNumber_369(char check) {
        boolean isExist;
        switch (check) {
            case '3':
            case '6':
            case '9':
                isExist = true;
                break;
            default:
                isExist = false;
        }
        return isExist;
    }
}