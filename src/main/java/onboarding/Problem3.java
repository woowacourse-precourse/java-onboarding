package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if ((number < 1) && (number > 10000)) return -1;

        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    public static int count369(int num) {
        int cnt = 0;
        if ((num / 1000 == 3) || (num / 1000 == 6) || (num / 1000 == 9)) {
            cnt++;
        }
        num %= 1000;
        if ((num / 100 == 3) || (num / 100 == 6) || (num / 100 == 9)) {
            cnt++;
        }
        num %= 100;
        if ((num / 10 == 3) || (num / 10 == 6) || (num / 10 == 9)) {
            cnt++;
        }
        num %= 10;
        if ((num == 3) || (num == 6) || (num == 9)) {
            cnt++;
        }
        return cnt;
    }
}
