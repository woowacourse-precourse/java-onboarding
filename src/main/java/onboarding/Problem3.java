package onboarding;

public class Problem3 {

    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static int countNum(String num) {
        long cnt3 = countChar(num, '3');
        long cnt6 = countChar(num, '6');
        long cnt9 = countChar(num, '9');
        return (int)(cnt3 + cnt6 + cnt9);
    }

    public static int countTotal(int number) {
        int total = 0;
        for (int i=1; i<=number; i++) {
            String num = Integer.toString(i);
            total += countNum(num);
        }
        return total;
    }
    public static int solution(int number) {
        return countTotal(number);
    }
}
