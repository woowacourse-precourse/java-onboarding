package onboarding;

/*
기능 구현 사항
1. 각 숫자마다 3,6,9가 포함되어 있는지 확인
구현 시 유의사항
1. static 변수를 사용하면 테스트 케이스에서 공유된다. 1번 케이스와 2번 케이스의 결과가 합쳐져서 나온다.
*/

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += defineThreeSixNine(i);
        }
        return answer;
    }

    public static int defineThreeSixNine(int number) {
        int clap = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                clap++;
            }
        }
        return clap;
    }
}
