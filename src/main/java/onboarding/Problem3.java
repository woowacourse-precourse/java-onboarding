package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1 ; i<=number; i++) {
            int num = i;
            while (num>0) {
                int temp = num % 10;
                if((temp == 3) || (temp == 6) || (temp == 9)) {
                    answer += 1;
                }
                num /= 10;
            }
        }

        return answer;
    }
}
