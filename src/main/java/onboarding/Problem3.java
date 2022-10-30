package onboarding;


/**
 *  getClapCount 메서드 1부터 n까지 3,6,9가 들어가면 카운트를 증가시키고 그 값을 반환
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    private static int getClapCount(int number){
        int clapCount = 0;
        for(int i = 1; i <= number; i++) {
            clapCount += String.valueOf(i)
                    .chars()
                    .filter(num -> num == '3' || num == '6' || num == '9').count();
        }
        return clapCount;
    }
}