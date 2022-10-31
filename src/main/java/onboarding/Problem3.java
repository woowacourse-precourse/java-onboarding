package onboarding;

/* 기능 목록
 * 숫자에 포함된 3, 6, 9의 개수 반환 기능
 * 1부터 number까지 반복 기능
 * */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    /**
     * 숫자에 포함된 3, 6, 9의 개수 반환합니다.
     *
     * @param num 3, 6, 9의 개수를 검사할 숫자
     * @return 3, 6, 9의 개수를 반환
     */
    static int count369(int num) {
        int cnt = 0;

        while (num > 2) {
            if (num % 10 != 0 && (num % 10) % 3 == 0) {
                cnt++;
            }
            num /= 10;
        }

        return cnt;
    }
}
