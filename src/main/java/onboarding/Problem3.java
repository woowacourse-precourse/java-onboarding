/*
 *기능목록
 * 1. 3의 개수를 세는 함수
 */
package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int numMod(int num) {
        int answer = 0;
        while(num > 0) {
            int mod = num % 10;
            if(mod != 0 && mod % 3 == 0) answer++;
            num /= 10;
        }
        return answer;
    }
}
