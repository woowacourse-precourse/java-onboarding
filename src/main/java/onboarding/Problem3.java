package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(isException(number)) return -1;
        int answer = 0;
        return answer;
    }

    private static Boolean isException(Integer number){
        return number < 0 || number > 10000;
    }
}
