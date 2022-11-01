package onboarding;

public class Problem3 {
    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static int solution(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            String stringNum = String.valueOf(i);
            cnt += countChar(stringNum, '3');
            cnt += countChar(stringNum, '6');
            cnt += countChar(stringNum, '9');

        }
        return cnt;
    }
}
