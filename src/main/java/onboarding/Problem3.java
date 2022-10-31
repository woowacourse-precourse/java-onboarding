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
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
