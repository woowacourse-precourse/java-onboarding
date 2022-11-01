package onboarding;

public class Problem3 {
    public static int solution(int number) {

        // 총 손뼉 횟수의 합
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += game(i);
        }

        return result;
    }

    public static int game(int num) {

        int tmp = num;
        int cnt = 0;

        while (tmp != 0) {
            cnt += count(tmp % 10);
            tmp /= 10;
        }

        return cnt;
    }

    public static int count(int num) {
        int cnt = 0;
        if (num == 3 || num == 6 || num == 9) {
            cnt += 1;
        }
        return cnt;
    }
}
