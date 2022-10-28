package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /**
     * 입력값의 범위 지정, 오류 처리*/
    private static void check(int number) {
        if(number < 1 || number > 10000)
            throw new IllegalArgumentException("숫자의 범위를 확인하세요");
    }

}
