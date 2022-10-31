package onboarding;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - number는 1 이상 10,000 이하인 자연수이다.
 * - 누적된 박수 횟수를 return
 *
 * 1. 접근 방식
 * - 다이나믹 프로그래밍 / 탑다운 방식 으로 접근(accumClapCount())
 *  _ 현재(number) 누적 박수 횟수 = 그 전(number-1) 누적 박수 횟수 + 현재 박수 횟수
 *  _ 현재 박수 횟수를 구하는 메소드(calcClapCount) 생성
 *  _ 그전 누적 박수 횟수는 accumClapCount() 메소드 재귀 호출
 *
 * 2. 3,6,9 계산 방식
 * - 일의 자리수 일 때와 그 이상일 때로 구분
 * - 일의 자리수의 경우 %10 를 이용하여 비교연산
 * - 그 이상일때는 가장 큰 자리수 부터 하나씩 내려가면서 비교
 *  _ 내려가는 시퀀스는 다음 자리수 비교를 위해 해당 자리수를 빼주고 비교할 자리수를 내려준다.(37890 -> 37890 - 30000 -> 7890)
 *
 * */
public class Problem3 {

    // 메모제이션
    private int[] memory = new int[10001];

    public static int solution(int number) {
        Problem3 problem3 = new Problem3();
        int answer = problem3.accumClapCount(number);

        return answer;
    }

    // 누적되는 박수 획수 다이나믹 프로그래밍으로 계산
    public int accumClapCount(int number){
        // 종료 조건
        if(number == 1 || number == 2){
            return 0;
        }

        // 메모제이션에 존재하는 값이라면 그대로 반환
        if(memory[number] != 0){
            return memory[number];
        }

        // 메모제이션에 존재하지 않는 값이라면 현재 누적 박수 횟수 = 그 전(number-1) 누적 박수 횟수 + 현재 박수 횟수
        memory[number] = accumClapCount(number-1) + calcClapCount(number);

        return memory[number];
    }

    // 개별 number에서 박수 횟수 계산
    public int calcClapCount(int number){
        int numberLength = String.valueOf(number).length();
        int answer = 0;
        int digit; // 3,6,9 인지 비교할 각 자리의 숫자

        if (numberLength == 1) {        // 일의 자리수 일때
            digit = number % 10;
            answer += isThreeContain(digit);
        } else {        // 십의 자리수 이상 일때
            answer += calcLargeNumClapCount(number,numberLength);
        }

        return answer;
    }

    // 십의 자리수 이상 일때 박수 횟수 계산(가장 큰 자리수 부터 하나씩 내려가면서 비교해준다.)
    public int calcLargeNumClapCount(int number, int numberLength){
        int digit;
        int answer =0;

        while (numberLength > 0) {
            // 해당 자리수에서 3,6,9 비교
            digit = (int) (number / (Math.pow(10, numberLength - 1))); // 가장 큰 자리수 부터 -> 가장 작은 자리수
            answer += isThreeContain(digit);

            // 다음 자리수 비교를 위해 해당 자리수를 빼주고 비교할 자리수를 내려준다.
            number = (int) (number - (digit * (Math.pow(10, numberLength-1))));
            numberLength--;
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
