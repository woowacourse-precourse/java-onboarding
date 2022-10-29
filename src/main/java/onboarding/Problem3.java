package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            answer += clap(i);
        }
        return answer;
    }

    public static int clap(int current) {
        int count = 0;

        while(current != 0) {
            if ((current%10)%3 == 0 && (current%10) != 0) {
                count++;
                current /= 10;
            }else current /= 10;
        }

        return count;
    }
}
