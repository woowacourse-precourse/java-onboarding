package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static void game369(int number) {
        if (number <= 0) {
            return ;
        }

        int seperatedNumber = number % 10;

        game369(number / 10);
    }
}
