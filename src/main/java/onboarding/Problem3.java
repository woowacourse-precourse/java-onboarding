package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i =1 ; i <= number; i++) {

            String s = Integer.toString(i);
            answer += countChar(s, '3');
            answer += countChar(s, '6');
            answer += countChar(s, '9');
        }

        return answer;
    }

    private static long countChar(String str, char ch) {
        return str.chars()
            .filter(c -> c == ch)
            .count();
    }
}
