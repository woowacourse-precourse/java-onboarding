package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    //일의 자리에 369가 들어간 숫자가 총 몇 개인가?
    // ex) 333
    // -> howMany10s = 33
    // ->  units = 3
    // -> 10번
    private static int get3or6or9(int num) {
        int howMany10s = num / 10;
        int units = num % 10;

        return howMany10s * 3 + units / 3;
    }
}
