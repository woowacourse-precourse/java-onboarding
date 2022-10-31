package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int countClap(int number) {
        int result = 0;
        while (number != 0){
            if ((number % 10 != 0) && ((number % 10) % 3 == 0)){
                result++;
            }
            number /= 10;
        }
        return result;
    }
}
