package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i += 1) {
            count = changeCountByExists(i, count);
        }
        return count;
    }
    public static int changeCountByExists(int number, int count) {
        for (int j = 0; j < numberStringify(number).length(); j += 1) {
            if (isNumber369(numberStringify(number), j)) { count += 1; }
        }
        return count;
    }

    public static String numberStringify(int number){
        return number + "";
    }

    public static boolean isNumber369(String string, int j){
        return string.charAt(j) == '3' || string.charAt(j) == '6' || string.charAt(j) == '9';
    }

}