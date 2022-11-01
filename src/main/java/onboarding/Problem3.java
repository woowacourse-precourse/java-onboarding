package onboarding;

public class Problem3 {
    private static int needClap(int n){
        int ans = 0;
        while (n != 0){
            int unit_d = n % 10;
            if (unit_d != 0 && unit_d % 3 == 0)
                ans++;
            n/=10;
        }
        return ans;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
