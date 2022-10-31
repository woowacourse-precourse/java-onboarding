package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(number < 1 || number > 10000) return -1; // 숫자 범위 예외처리
        for(int i=1; i<=number; i++) {
            answer += clap(i);
        }
        return answer;
    }

    public static int clap(int num) {
        int cnt = 0;
        String target;
        while(num != 0) {
            target = Integer.toString(num % 10);
            if(target.contains("3")) cnt++;
            if(target.contains("6")) cnt++;
            if(target.contains("9")) cnt++;
            num /= 10;
        }
        return cnt;
    }
}
