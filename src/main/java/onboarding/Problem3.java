package onboarding;

public class Problem3 {
    public static int get369(int num){
        int add=0;
        while(num > 0) {
            if ((num %10)==3 ||(num %10)==6||(num %10)==9 ) add+= 1;
            num /= 10;
        }
        return add;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer+=get369(i);
        }
        return answer;
    }
}
