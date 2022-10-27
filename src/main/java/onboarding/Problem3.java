package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += checkNumber(i);
        }
        return answer;
    }

    static int checkNumber(int num) {
        int result = 0;
        while(num > 0) {
            int tmp = num % 10;
            if(tmp == 3 || tmp == 6 || tmp == 9) {
                result++;
            }
            num /= 10;
        }
        return result;
    }
}
