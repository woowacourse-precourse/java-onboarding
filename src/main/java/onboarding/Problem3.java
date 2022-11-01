package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // Count
        int answer = 0;


        for(int i = 1 ; i <= number; i++) {

            if(i/10 == 3 || i/10 == 6 || i/10 == 9) answer++;
            if(i%10 == 3 || i%10 == 6 || i%10 == 9) answer++;
        }
        return answer;
    }
}
