package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            int val = i;
            while(val != 0) {
                if(val % 10 == 3 || val % 10 == 6 || val % 10 == 9)
                    answer++;
                val /= 10;
            }
        }

        return answer;
    }
}
