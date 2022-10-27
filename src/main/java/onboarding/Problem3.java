package onboarding;

/*
 * # 기능 정리
 * [X] 목표한 숫자까지 순회 메서드
 * [X] 각 숫자 별 결과값 확인 메서드
 * [X] solution 작성
 * [X] 테스트 확인
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = getAnswer(number);
        return answer;
    }

    private static int getAnswer(int number) {
        int calculateAnswer = 0;
        for(int i = 3; i <= number; i++){
            //calculateAnswer += clapOnNumber(i);
        }
        return calculateAnswer;
    }
}
