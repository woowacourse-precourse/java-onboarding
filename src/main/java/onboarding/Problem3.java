package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int current = i;
            while(current != 0) {
                if(current % 10 == 3 || current % 10 == 6 || current % 10 == 9) {
                    answer++;
                }
                current /= 10;
            }
        }
        return answer;
    }
}
