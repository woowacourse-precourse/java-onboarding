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

    public static int checknumber(int n){
        count=0;
        while(n!=0) {
            if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {
                count++;
            }
            n/=10;
        }
        return count;
    }
}
