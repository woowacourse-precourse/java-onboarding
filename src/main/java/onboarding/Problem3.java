package onboarding;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - number는 1 이상 10,000 이하인 자연수이다.
 * - 누적된 박수 횟수를 return
 *
 * 1. 접근 방식
 * - 다이나믹 프로그래밍 방식 / 탑다운 방식 으로 접근
 *
 * */
public class Problem3 {

    // 메모제이션
    private int[] memory = new int[10000];

    public static int solution(int number) {

        int answer = 0;
        
        return answer;
    }

    // 개별 number에서 박수 횟수 계산
    public int calcClapCount(int number){
        int numberLength = String.valueOf(number).length();
        int answer = 0;
        int digit = 0; // 3,6,9 인지 비교할 각 자리의 숫자

        if (numberLength == 1) {
            // 일의 자리수 일때
            digit = number % 10;
            answer += isThreeContain(digit);
        } else {
            // 십의 자리수 이상 일때 가장 큰 자리수 부터 하나씩 내려가면서 비교해준다.
            while (numberLength > 0) {
                // 해당 자리수에서 3,6,9 비교
                digit = (int) (number / (Math.pow(10, numberLength - 1)));
                answer += isThreeContain(digit);

                // 다음 자리수 비교를 위해 해당 자리수를 빼주고 비교할 자리수를 내려준다.
                number = (int) (number - (digit * (Math.pow(10, numberLength-1))));
                numberLength--;
            }
        }

        return answer;
    }

    // 매개변수 숫자가 3,6,9 인지 확인
    public int isThreeContain(int digit){
        int answer = 0;
        if ((digit == 3) || (digit == 6) || (digit == 9))
            answer = 1;

        return answer;
    }

}
