package onboarding;

/**
 * [o] 1부터 주어지는 number까지 손뼉을 치는 횟수를 구한다.
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = getClap(number);

        return answer;
    }

    public static int getClap(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            int current = i;
            while (current != 0) {
                if (current % 10 == 3 || current % 10 == 6 || current % 10 == 9) {
                    cnt++;
                }
                current /= 10;
            }
        }
        return cnt;
    }
}
