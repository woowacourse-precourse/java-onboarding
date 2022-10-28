package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1 ; i < number+1 ; i++) {

            int nowNumber = i;

            while (nowNumber != 0) {
                if (nowNumber % 10 == 3 || nowNumber % 10 == 6 || nowNumber % 10 == 9) {
                    answer += 1;
                }
                nowNumber /= 10;
            }

        }
        return answer;
    }
}
