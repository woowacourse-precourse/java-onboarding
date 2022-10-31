package onboarding;

/**
 * 📚 기능 목록
 *
 * 1. 주어진 숫자에서 3,6,9의 개수를 구하는 기능
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getClapCount(i);
        }

        return answer;
    }

    private static int getClapCount(int number) {
        String str = String.valueOf(number);
        return str.replaceAll("[^3|6|9]", "").length();
    }
}
