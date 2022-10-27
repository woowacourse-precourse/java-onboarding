package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i += 1) {
            count = check369Exists(i, count);
        }
        return count;
    }
    public static int check369Exists(int number, int count) {
        String stringifiedNumber = numberStringify(number);
        for (int j = 0; j < stringifiedNumber.length(); j += 1) {
            if (stringifiedNumber.charAt(j) == '3' || stringifiedNumber.charAt(j) == '6' || stringifiedNumber.charAt(j) == '9') {
                count += 1;
            }
        }
        return count;
    }

    public static String numberStringify(int number){
        return number + "";
    }

}