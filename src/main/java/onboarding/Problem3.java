package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += getClap(i);
        }

        return answer;
    }

    private static int getClap(int num) {
        int cnt = 0;
        int temp;

        while(num != 0) {
            temp = num % 10;
            if(temp % 3 == 0 && temp != 0) {
                cnt++;
            }
            num /= 10;
        }

        return cnt;
    }
}
