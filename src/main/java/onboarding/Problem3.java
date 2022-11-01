package onboarding;

/*
 * # 기능 정리
 * [O] 목표한 숫자까지 순회 메서드
 * [O] 각 숫자 별 결과값 확인 메서드
 * [O] solution 작성
 * [O] 테스트 확인
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = getAnswer(number);
        return answer;
    }

    private static int getAnswer(int number) {
        int calculateAnswer = 0;
        for(int i = 3; i <= number; i++){
            calculateAnswer += clapOnNumber(i);
        }
        return calculateAnswer;
    }

    private static int clapOnNumber(int i) {
        int clapCount = 0;

        while(i > 0){
            int lastNumber = i % 10; i /= 10;

            if(lastNumber != 0 && lastNumber % 3 == 0)
                clapCount++;
        }

        return clapCount;
    }
}
