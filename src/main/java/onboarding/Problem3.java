package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String str = String.valueOf(i);
            if (str.indexOf('3') != -1 || str.indexOf('6') != -1 || str.indexOf('9') != -1) {
                answer += countChar(str, '3');
                answer += countChar(str, '6');
                answer += countChar(str, '9');
            }
        }
        return answer;
    }

    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
