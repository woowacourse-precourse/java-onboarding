package onboarding;
public class Problem3 {
    static int return369(int a) {
        int result=0;
        int b = 0;
        while(a>0){
            b = a%10;
            a/=10;
            if(b == 3 || b == 6 || b == 9) {
                result++;
            }
        }
        return result;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += return369(i);
        }
        return answer;
    }
}
