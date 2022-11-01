package onboarding;

/**
 * 기능
 * 1. 해당 수의 3,6,9 개수 확인
 */
public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count(i);
        }
        return answer;
    }

    /**
     * 1. 해당 수의 3,6,9 개수 확인
     * @param num
     * @return 3, 6, 9가 들어가는 개수 반환
     */
    static int count(int num) {
        int res = 0;
        while (num != 0) {
            int tmp = num % 10;
            if (tmp == 3 || tmp == 6 || tmp == 9) {
                res++;
            }
            num /= 10;
        }
        return res;
    }
}
