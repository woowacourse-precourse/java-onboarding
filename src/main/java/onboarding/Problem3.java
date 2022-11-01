package onboarding;

public class Problem3 {
    static int countClap(int num) {
        int cnt = 0;
        int q = 0;
        while(num != 0) {
            q = num % 10;
            if(q != 0 && q % 3 == 0) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }
    static int playGame(int number) {
        int clap = 0;
        for(int num = 1; num <= number; num++) {
            clap += countClap(num);
        }
        return clap;
    }
    public static int solution(int number) {
        int answer = playGame(number);
        return answer;
    }
}
