package onboarding;

public class Problem3 {

    public static boolean validCheck(int number) {
        return number >= 1 && number <= 10000;
    }

    public static int solution(int number) {
        if (!validCheck(number)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        int answer = 0;
        return answer;
    }
}
