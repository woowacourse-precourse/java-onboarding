package onboarding;

/***
 * 기능목록
 * 1. 손뼉 치는 횟수 카운트 기능
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer = countClap(number);
    }

    public static int countClap(int number) {
        int cnt = 0;
        int temp = 0;
        int prev = 0;

        for (int i = 1; i <= number; i++) {
            prev = i;
            int len = Integer.toString(i).length();
            for (int j = 0; j < len; j++) {
                temp = prev % 10;
                if (temp == 3 || temp == 6 || temp == 9) cnt++;
                prev /= 10;
            }
        }
        return cnt;
    }
}
