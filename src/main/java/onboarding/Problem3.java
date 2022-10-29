package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++)
            answer += clapNum(i);

        return answer;
    }

    private static int clapNum(int num) {
        int clapTime = 0;

        while(num > 0) {
            int lastDec = num % 10;
            if (lastDec != 0 && lastDec % 3 == 0)
                clapTime++;
            num /= 10;
        }

        return clapTime;
    }
}
