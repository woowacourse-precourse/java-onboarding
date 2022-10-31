package onboarding;

public class Problem3 {
    static int claps(int num){

        int cnt = 0;
        while (num > 0) {
            int tmp = num % 10;
            if(tmp == 3 || tmp == 6 || tmp ==9) cnt++;
            num /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {

        int answer = 0;
        for(int i=1; i<=number; i++){
            answer += claps(i);
        }
        return answer;
    }
}
