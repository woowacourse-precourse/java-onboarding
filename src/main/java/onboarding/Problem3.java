package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int n = i;
            while(isNotZero(n)){
                if(Clap(n))
                    answer++;
                n /= 10;
            }
        }
        return answer;
    }
    static boolean isNotZero (int n) { return n != 0; }
    static boolean Clap (int n) { return n%10 == 3 || n%10 == 6 || n%10 == 9; }
}
