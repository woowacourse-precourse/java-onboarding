package onboarding;

/*
기능 구현 사항
1. 3, 6, 9가 들어있는지 확인
2. 해당 숫자에 3, 6, 9가 몇 개 있는지 확인
3. 1~number 까지 반복하고, 값 모두 더하기
 */

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for(int i = 1; i<=number; i++) {
            clapCount += countThreeNumber(i);
        }
        return clapCount;
    }

    private static int countThreeNumber(int number) {
        String stringNumber = String.valueOf(number);
        char[] threeNumber = {'3', '6', '9'};
        int clapCount = 0;
        for(int i = 0; i<stringNumber.length(); i++) {
            for (char c : threeNumber) {
                if (stringNumber.charAt(i) == c) {
                    clapCount++;
                }
            }
        }
        return clapCount;
    }
}
