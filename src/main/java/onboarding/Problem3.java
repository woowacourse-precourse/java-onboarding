package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            String convertedNumber = Integer.toString(i);
            sum += countOf369(convertedNumber);
        }
        return sum;
    }

    private static int countOf369(String num) {
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }
        return count;
    }
}
