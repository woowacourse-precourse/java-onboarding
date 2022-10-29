package onboarding;

public class Problem3 {
    private int getNumOfTSN(int num){
        int ret = 0;
        int a = num % 10;
        int b = num % 100 / 10;
        int c = num % 1000 / 100;
        int d = num % 10000 / 1000;
        if(a == 3 || a == 6 || a == 9)
            ++ret;
        if(b == 3 || b == 6 || b == 9)
            ++ret;
        if(c == 3 || c == 6 || c == 9)
            ++ret;
        if(d == 3 || d == 6 || d == 9)
            ++ret;
        return ret;
    }
    public static int solution(int number) {
        int answer = 0;
        Problem3 p3 = new Problem3();
        for(int i = 1; i <= number; ++i)
            answer += p3.getNumOfTSN(i);
        return answer;
    }
}
