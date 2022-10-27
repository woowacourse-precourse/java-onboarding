package onboarding;

public class Problem3 {
    public static boolean contain3or6or9(int number) {
        String stringNumber = String.valueOf(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            int digit = stringNumber.charAt(i);
            if (digit == 3 || digit == 6 || digit == 9) return true;
        }
        return false;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (contain3or6or9(i)) answer++;
        }
        return answer;
    }
}
