package onboarding;

public class Problem3 {
    /*
        기능 요구 사항 목록
        1. 숫자 당 박수 카운터 함수
        2. 숫자에 3,6,9가 포함되는지 확인하는 조건문
        3. 총 박수 횟수 구하는 함수
        4. solution 함수
    */

    // 3,6,9가 포함되면 인자에 1을 더하여 반환하는 함수
    private static int addClap(char numChar, int clap) {
        if (numChar == '3' || numChar == '6' || numChar == '9')
            clap += 1;
        return clap;
    }

    // 숫자 당 박수 카운터 함수
    private static int clapPerNumber(int clapNumber) {
        int clap = 0;
        String clapString = Integer.toString(clapNumber);

        for (int i = 0; i < clapString.length(); i++) {
            char numChar = clapString.charAt(i);
            clap = addClap(numChar, clap);
        }
        return clap;
    }

    private static int countTotalClaps(int lastNumber) {
        int totalClaps = 0;
        for (int i = 0; i <= lastNumber; i++) {
            int clap = clapPerNumber(i);
            totalClaps += clap;
        }
        return totalClaps;
    }

    public static int solution(int number) {
        return countTotalClaps(number);
    }
}
