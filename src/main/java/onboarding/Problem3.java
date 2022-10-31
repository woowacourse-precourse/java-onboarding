package onboarding;


/**
 *  getClapCount 메서드 1부터 n까지 3,6,9가 들어가면 카운트를 증가시키고 그 값을 환반환
 *  isProperNumber 메서드 number범위가 1~10000인지 확인
 */

public class Problem3 {
    public static int solution(int number) {
        isProperNumber(number);
        return getClapCount(number);
    }

    private static void isProperNumber(int number){
        if (number<1||number>10000)throw new IllegalArgumentException();
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