package onboarding;

/**
 * 기능 구현
 * 1. 박수 세는 알고리즘
 */
public class Problem3 {
    private static int countClap(int number){
        int tmp = 0;
        int clapCount = 0;
        while (number != 0){
            tmp = number % 10;
            if ((tmp % 3 == 0) && (tmp != 0)){ // tmp는 한 자리수이므로 3의 배수이기만 하면 박수를 치면 된다.
                clapCount++;
            }
            number /= 10;
        }
        return clapCount;
    }
    public static int solution(int number) {
        int answer = 0;
        while (number > 0){
            answer += countClap(number--);
        }
        return answer;
    }
}
