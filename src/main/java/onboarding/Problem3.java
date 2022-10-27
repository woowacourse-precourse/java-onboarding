package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    //숫자 하나에서 3,6,9가 몇 번 포함되어 있는지 확인하는 메서드
    private static int checkNum(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                cnt++;
                num /= 10;
            }
            if (num % 10 != 3 && num % 10 != 6 && num % 10 != 9) {
                num /= 10;
            }
        }
        return cnt;
    }
}
