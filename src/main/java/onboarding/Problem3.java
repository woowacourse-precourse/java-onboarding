package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++)
            answer += count(i);
        return answer;
    }

    public static int count(int n){
        int res = 0;
        while(n != 0){
            int temp = n % 10;
            if (temp % 3 == 0 && temp != 0) res++;
            n /= 10;
        }
        return res;
    }
}
