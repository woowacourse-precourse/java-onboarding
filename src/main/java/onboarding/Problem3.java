package onboarding;

public class Problem3 {

    int count = 0;
    public static int solution(int number) {
        Problem3 p3 = new Problem3();
        p3.iterate(number);
        return p3.count;
    }

    private void iterate(int number) {
        for(int i =1; i <= number; i++){
            count += countContain(i);
        }
    }

    private int countContain(int n) {
        int cnt = 0;
        while (n >= 1) {
            int m = n % 10;
            if(m !=0 && m%3 == 0) cnt++;
            n /= 10;
        }
        return cnt;
    }
}
