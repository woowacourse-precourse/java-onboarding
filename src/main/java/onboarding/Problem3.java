package onboarding;

public class Problem3 {
    public static int check369(int num) {
        int cnt = 0;
        while(num>0) {

            int a;
            a = num % 10;
            if(a != 0 && (a % 3 == 0 || a % 6 == 0 || a % 9 == 0)) {
                cnt++;
            }
            num = num / 10;
        }
        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i<= number; i++) {
            answer += check369(i);

        }

        return answer;
    }
}
