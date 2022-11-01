/**
 * 클래스 이름
 * - 문제 3
 *
 * 버전정보
 * - jdk-11.0.17
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int num = i;

            // 각 숫자의 박수치는 횟수 카운트
            answer += getClapCount(num);
        }

        return answer;
    }

    // 해당 숫자에 3, 6, 9가 몇개 들어가 있는지 확인하는 메소드
    private static int getClapCount(int num) {
        int count = 0;
        while (num != 0) {
            int rest = num % 10;
            num /= 10;
            // 3, 6, 9 인지 확인하고 맞다면 박수 카운트 증가
            if (checkClap(rest)) {
                count++;
            }
        }
        return count;
    }

    // 3, 6, 9 인지 확인하는 메소드
    private static boolean checkClap(int num){
        return num == 3 || num == 6 || num == 9;
    }
}
