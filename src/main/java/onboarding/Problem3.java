package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += numberOfClaps(i);
        }

        return answer;
    }

    public static int numberOfClaps(int number){
        int len = (int)(Math.log10(number) + 1);
        int cnt = 0;

        while(len > 0){
            int n = (int)(number / Math.pow(10, len - 1));
            if(n == 3 || n == 6 || n == 9){
                cnt++;
            }

            number %= Math.pow(10, len - 1);
            len--;
        }

        return cnt;
    }
}
