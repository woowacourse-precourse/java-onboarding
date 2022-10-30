package onboarding;

public class Problem3 {

    public static int clap(int num, int cnt){
        if (num == 0)
            return cnt;
        if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9){
            cnt ++;
        }
        num /= 10;
        return clap(num, cnt);

    }
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1;  i <= number; i++){
            int current = i;
            answer = clap(current, answer);
        }

        return answer;
    }
}
