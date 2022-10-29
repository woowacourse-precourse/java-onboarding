package onboarding;

/**
 * 큰 틀의 기능 구현
 * 1. 입력값 체크 함수 -> number는 1 이상 10,000 이하 범위가 아닌 다른 수 일 때 예외처리
 * 2. 각 숫자를 split을 통해 배열로 만들 함수  ex> 369 -> {3,6,9}
 * 3. 배열을 읽으면서 3,6,9 포함시 int 값 상승 후 그 결과값 return 함수
 */

/**
 * 1. 입력값 체크 함수 -> number는 1 이상 10,000 이하 범위가 아닌 다른 수 일 때 예외처리
 * -  예외 일때 return 값을 -1 음수로 부여 true일 때 0
 *
 */


public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int checkInput(int inputNum){
        if(inputNum < 1 || inputNum > 10000)
            return -1;
        return 0;
    }
}
