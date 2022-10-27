package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // 손뼉 카운트
        // 반복문 루프로? or 자릿수 별 수열 합?
        // 반복문
        // 1. 1부터 number 까지 진행하는 루프
        // 2. 루프별 해당하는 숫자 자릿수 분리
        // 3. 각 자릿수에 3, 6, 9가 있는지 체크
        // 4. 있다면 손뼉 카운트
        int cnt = 0; // 카운트 변수

        for(int i = 1; i <= number; i++) { // 1 ~ number까지 순환 하는 루프
            int tmp1 = i; // number가 저장될 변수
            int tmp2 = 0; // 각각의 자릿수가 저장될 변수

            for(; tmp1 != 0;) { // 자릿수 분리, 1의 자리 부터 체크
                tmp2 = tmp1 % 10;

                if(tmp2 == 3 || tmp2 == 6 || tmp2 == 9) { // 분리된 자릿수가 3, 6, 9중 하나에 해당하면 카운트 변수 증가
                    cnt++;
                }

                tmp1 /= 10;
            }
        }

        return cnt;
        // 불필요한 연산 줄여야...
        // 테스트 케이스 통과
    }
}