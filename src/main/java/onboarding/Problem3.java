package onboarding;

public class Problem3 {
    private static int count;
    private static int sum;
    public static int solution(int number) {
        int answer = 0;
        return Howmany(number);
    }

    public static int Howmany(int n){
        sum=0;
        if(!error(n)) {
            for (int i = 0; i <= n; i++) {
                sum += checknumber(i);
            }
        }
        return sum;
    }
}
