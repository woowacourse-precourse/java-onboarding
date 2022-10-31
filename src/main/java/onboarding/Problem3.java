package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int temp, rest;
        for(int i = 1; i <= number; i++) {
            temp = i;
            while(temp != 0) {
                rest = temp % 10;
                if(rest == 3 || rest == 6 || rest == 9) answer++;
                temp /= 10;
            }
        }
        return answer;
    }
}