package onboarding;

public class Problem3 {
    public static int solution(int number) throws Exception {
        int answer = 0;
        validate(number);
        return answer;
    }

    private static void validate(int number) throws Exception {
        if(number < 1 || number > 10000) {
            throw new Exception("number가 범위를 벗어났습니다");
        }
    }
}
