package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static long countChar(String str, char num) {
        return str.chars()
                .filter(c -> c == num)
                .count();
    }

    public static int countTotal(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += countChar(String.valueOf(i), '3');
            count += countChar(String.valueOf(i), '6');
            count += countChar(String.valueOf(i), '9');
        }
        return count;
    }
}
