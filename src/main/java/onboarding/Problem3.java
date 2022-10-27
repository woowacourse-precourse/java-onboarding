package onboarding;

public class Problem3 {
    /*
        기능 요구 사항 목록
        1. 숫자 당 박수 카운터 함수
        2. solution (반복문으로 총 박수 횟수 구하기)
    */

    // 숫자 당 박수 카운터 함수
    private static int clapPerNumber(int number) {
        int clap = 0;
        String numString = Integer.toString(number);

        for (int i = 0; i < numString.length(); i++) {
            char numChar = numString.charAt(i);
            if (numChar == '3' || numChar == '6' || numChar == '9')
                clap += 1;
        }
        return clap;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            int clap = clapPerNumber(i);
            answer += clap;
        }

        return answer;
    }
}
