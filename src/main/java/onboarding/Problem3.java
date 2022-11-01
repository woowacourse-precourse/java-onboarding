package onboarding;

public class Problem3 {
    private static final int MIN = 1;
    private static final int MAX = 10000;

    public static int solution(int number) {
        if (!canNumber(number)) {
            throw new IllegalArgumentException("제한 사항을 위반하였습니다.");
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369(Integer.toString(i));
        }
        return answer;
    }
    public static int count369(String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean canNumber(int number) {
        if (number >= MIN && number <= MAX) return true;
        return false;
    }


}
