package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = countNumber(number);

        return answer;
    }

    /**
     * DESCRIPTION
     *   전달받은 숫자까지 3,6,9가 포함된 숫자의 개수를 기능
     *
     * Params
     *   number - 조사할 숫자 범위
     *
     * RETURN
     *   number 까지의 박수 횟수
     */
    public static int countNumber(int max){

        int clapCount = 0; // 박수 횟수를 저장

        for(int num = 1; num <= max; num++) { // 주어진 max 값까지 검사
            int divided = 0; // 현재 조사 중인 숫자의 각 자리 수를 저장
            int temp = num; // 현재 조사 중인 숫자의 분해를 위해, 임시로 사용

            while(temp > 0) { // 현재 조사 중인 숫자의 각 자리 수를 분해
                divided = temp % 10;

                // 조건 1. 나눠진 자리 수가 3의 배수
                // 조건 2. 나눠진 자리 수가 0이 아님
                if(divided % 3 == 0 && divided != 0)
                    clapCount ++;

                temp /= 10;
            }
        }

        return clapCount;

    }
}
