package onboarding;

/**
 *  문제 분석
 *  1. 1부터 number 까지 반복문 을 돌리며 모든 값들에 대에 숫자 3,6,9 의 개수 를 카운트 한다.
 *  2. 사용 되는 메서드는 총 1개 이다.
 *      1. input 값에 대해 숫자 3,6,9 의 등장 횟수 를 반환하는 메서드
 *
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getCount(i);
        }
        return answer;
    }

    static int getCount(int input) {
        int result =0;
        while (input > 0) {
            int tmp =input % 10;
            switch (tmp) {
                case 3: case 6: case 9:
                    result++;
            }
            input /= 10;
        }
        return result;
    }
}
