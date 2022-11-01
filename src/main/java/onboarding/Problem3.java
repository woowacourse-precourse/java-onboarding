package onboarding;

public class Problem3 {
    /* 기능 단위
     * 1. 자릿수와 자릿수에 따른 10의 거듭제곱 구하기 (getDigit, getPowerByDigit)
     *   a. ex) 234 -> 자릿수: 3, 자릿수에 따른 10의 거듭제곱: 100
     * 2. 자릿수에 따른 손뼉 수 구하기 (clapByDigit)
     *   a. 아래 알고리즘을 따름
     *   b. clap[i] = clap[i-1] + clap[i-1]*9 + (int) Math.pow(10, i)*3
     * 3. 1부터 number까지 손뼉 수 구하기 (clapByNumber)
     * */

    private static int getDigit(int number) {
        return (int) (Math.log10(number)+1);
    }

    private static int getPowerByDigit(int digit) {
        return ((int) Math.pow(10, digit-1));
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
